package com.example.rettrofitpractick.presentation.products

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rettrofitpractick.data.repository.FavoriteProductRepositoryImpl
import com.example.rettrofitpractick.data.repository.ProductRepositoryImpl
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.useCase.FavoriteProductUseCase.AddFavoriteProductUseCase
import com.example.rettrofitpractick.domain.useCase.FavoriteProductUseCase.DeleteFavoriteProductUseCase
import com.example.rettrofitpractick.domain.useCase.ProductUseCase.GetProductInfoUseCase
import com.example.rettrofitpractick.domain.useCase.ProductUseCase.GetProductListByFavorite
import com.example.rettrofitpractick.domain.useCase.ProductUseCase.LoadProductListUseCase
import com.example.rettrofitpractick.domain.useCase.ProductUseCase.SearchProductsByTitleUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(
    application: Application,
    val user: User
) : AndroidViewModel(application) {

    private val repository = ProductRepositoryImpl(application)
    private val repositoryFavorite = FavoriteProductRepositoryImpl(application)

    private val getListProductByFavorite = GetProductListByFavorite(repository)
    private val infoProduct = GetProductInfoUseCase(repository)
    private val loadList = LoadProductListUseCase(repository)
    private val search = SearchProductsByTitleUseCase(repository)

    private val addFavorite = AddFavoriteProductUseCase(repositoryFavorite)
    private val deleteFavorite = DeleteFavoriteProductUseCase(repositoryFavorite)


    init {
        load()
    }

    val listProduct = getListProductByFavorite(user.id)
    var searchList = MutableLiveData<List<ProductModel>>()


    fun getProductInfo(id: Int) = infoProduct(id)

    private fun load() {
        viewModelScope.launch() {
            loadList()
        }
    }

    fun likeToFavoriteProduct(idProduct: Int, favoriteStatus: Boolean) {

            viewModelScope.launch {
                if (favoriteStatus) {
                addFavorite(
                    userId = user.id,
                    productId = idProduct,
                    favoriteStatus = favoriteStatus
                )
                } else {
                    deleteFavorite(
                        userId = user.id,
                        productId = idProduct,
                    )
                }
            }
    }

    fun searchProducts(query: String) {
        viewModelScope.launch() {
            searchList.value = search(query)
        }
    }


}