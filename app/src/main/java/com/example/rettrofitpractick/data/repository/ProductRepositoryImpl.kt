package com.example.rettrofitpractick.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.rettrofitpractick.data.database.AppDatabase
import com.example.rettrofitpractick.data.mappers.ProductMapper
import com.example.rettrofitpractick.data.network.ApiFactory
import com.example.rettrofitpractick.data.network.model.AuthRequestDtoModel
import com.example.rettrofitpractick.domain.ProductRepository
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User
import java.io.IOException

class ProductRepositoryImpl(
    val application: Application
) : ProductRepository {

    private val dataDao = AppDatabase.getInstance(application).productDao()
    private val apiService = ApiFactory.apiService
    private val mapper = ProductMapper()

    override fun getProductList(): LiveData<List<ProductModel>> {
        Log.d("ProductRepositoryImpl", "getProductList()")

        return dataDao.getProductList().map { mapper.mapDbModelListToEntityList(it) }
    }

    override fun getProductInfo(id: Int): LiveData<ProductModel> {
        Log.d("ProductRepositoryImpl", "getProductInfo() ")

        return dataDao.getProductInfo(id).map { mapper.mapDbModelToEntity(it) }
    }

    override suspend fun loadData() {
        val productCount = dataDao.getProductCount()
        Log.d("ProductRepositoryImpl", "productCount| $productCount ")
        if (productCount == 0) {
            try {
                val listFromNetwork = apiService.getProducts()
                Log.d(
                    "ProductRepositoryImpl",
                    "listFromNetwork | ${listFromNetwork.productModels.toString()}"
                )
                val listDb =
                    listFromNetwork.productModels?.let { mapper.mapDtoListToDbList(it) }
                Log.d(
                    "ProductRepositoryImpl",
                    "listDb | ${listDb.toString()}"
                )
                dataDao.insertProductList(listDb!!)
            } catch (e: Exception) {
                Log.d("ProductRepositoryImpl", "loadData | e: Exception ")
            }

        }

    }

    override suspend fun auth(username: String, password: String): ResultAuth<User> {
        try {

            val userDto = apiService.auth(
                AuthRequestDtoModel(
                    username,
                    password
                )
            )
            val user = mapper.mapDtoUserToDbModelUser(userDto)
            Log.d("LoginFragment", "Exception = $user")
            return ResultAuth.Success(user)
        } catch (e: Exception) {
            return  ResultAuth.Error(IOException("Error logging in", e))
        }
    }

}