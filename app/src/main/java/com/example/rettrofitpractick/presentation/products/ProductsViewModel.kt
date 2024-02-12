package com.example.rettrofitpractick.presentation.products

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rettrofitpractick.data.repository.LoginRepositoryImpl
import com.example.rettrofitpractick.data.repository.ProductRepositoryImpl
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.useCase.GetProductInfoUseCase
import com.example.rettrofitpractick.domain.useCase.GetProductListUseCase
import com.example.rettrofitpractick.domain.useCase.GetUserByTokenUseCase
import com.example.rettrofitpractick.domain.useCase.LoadProductListUseCase
import com.example.rettrofitpractick.domain.useCase.SearchProductsByTitleUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(
    application: Application,
    token:String
) : AndroidViewModel(application) {

    private val repository = ProductRepositoryImpl(application)
    private val repositoryUser = LoginRepositoryImpl(application)

    private val getListProduct = GetProductListUseCase(repository)
    private val infoProduct = GetProductInfoUseCase(repository)
    private val loadList = LoadProductListUseCase(repository)
    private val getUser = GetUserByTokenUseCase(repositoryUser)
    private val search = SearchProductsByTitleUseCase(repository)


    init {
        load()
    }

    val listProduct = getListProduct()
    val user = getUser(token)
    var searchList = MutableLiveData<List<ProductModel>>()

    fun getProductInfo(id: Int) = infoProduct(id)

    private fun load() {
        viewModelScope.launch() {
            loadList()
        }
    }

    fun searchProducts( query: String){
        viewModelScope.launch(){
            searchList.value = search(query)
        }
    }







}