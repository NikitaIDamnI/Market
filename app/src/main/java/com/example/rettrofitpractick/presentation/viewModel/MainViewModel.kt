package com.example.rettrofitpractick.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rettrofitpractick.data.repository.ProductRepositoryImpl
import com.example.rettrofitpractick.domain.useCase.GetProductInfoUseCase
import com.example.rettrofitpractick.domain.useCase.GetProductListUseCase
import com.example.rettrofitpractick.domain.useCase.LoadProductListUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = ProductRepositoryImpl(application)

    private val getListProduct = GetProductListUseCase(repository)
    private val infoProduct = GetProductInfoUseCase(repository)
    private val loadList = LoadProductListUseCase(repository)


    init {
        load()
    }

    val listProduct = getListProduct()

    fun getProductInfo(id: Int) = infoProduct(id)

    private fun load() {
        viewModelScope.launch() {
            loadList()
        }
    }


}