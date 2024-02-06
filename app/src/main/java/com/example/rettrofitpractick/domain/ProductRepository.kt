package com.example.rettrofitpractick.domain

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.model.ProductModel

interface ProductRepository {


    fun getProductList(): LiveData<List<ProductModel>>

    fun getProductInfo(id: Int): LiveData<ProductModel>

    suspend fun loadData()

}