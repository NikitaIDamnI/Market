package com.example.rettrofitpractick.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.rettrofitpractick.data.database.AppDatabase
import com.example.rettrofitpractick.data.mappers.ProductMapper
import com.example.rettrofitpractick.data.network.ApiFactory
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.repository.ProductRepository

class ProductRepositoryImpl(
   private val application: Application
) : ProductRepository {

    private val productDao = AppDatabase.getInstance(application).productDao()
    private val apiService = ApiFactory.apiService
    private val mapper = ProductMapper()

    override fun getProductList(): LiveData<List<ProductModel>> {
        Log.d("ProductRepositoryImpl", "getProductList()")

        return productDao.getProductList().map { mapper.mapDbModelListToEntityList(it) }
    }

    /*
    override fun getProductListByFavorite(userId:Int): LiveData<List<ProductByFavorite>> {
        Log.d("ProductRepositoryImpl", "getProductList()")

        val favoriteList = productDao.getProductByUserFavorite(userId).map {entities->
            entities.map {
                val product = it.key
                val favorite = it.value
                ProductByFavorite(
                    id = product.id,
                    title =  product.title,
                    price = product.price,
                    images = mapper.stingToList(product.images),
                    favorite = favorite.isFavorite
                )
            }

        }
        return favoriteList
    }

     */
    override fun getProductInfo(id: Int): LiveData<ProductModel> {
        Log.d("ProductRepositoryImpl", "getProductInfo() ")

        return productDao.getProductInfo(id).map { mapper.mapDbModelToEntity(it) }
    }

    override suspend fun loadData() {
        val productCount = productDao.getProductCount()
        Log.d("ProductRepositoryImpl", "productCount| $productCount ")
        if (productCount == 0) {
            try {
                val listFromNetwork = apiService.getProducts()

                val listDb =
                    listFromNetwork.productModels?.let { mapper.mapDtoListToDbList(it) }

                productDao.insertProductList(listDb!!)
            } catch (e: Exception) {
                Log.d("ProductRepositoryImpl", "loadData | e: Exception ")
            }

        }

    }

    override suspend fun searchProductsByTitle(query: String): List<ProductModel> {
        return mapper.mapDbModelListToEntityList( productDao.searchProductsByTitle(query))
    }


}