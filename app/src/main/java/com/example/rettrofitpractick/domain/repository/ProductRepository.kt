package com.example.rettrofitpractick.domain.repository

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User

interface ProductRepository {


    fun getProductList(): LiveData<List<ProductModel>>

    fun getProductInfo(id: Int): LiveData<ProductModel>

    suspend fun loadData()

    suspend fun auth(username: String, password: String): ResultAuth<User>

}