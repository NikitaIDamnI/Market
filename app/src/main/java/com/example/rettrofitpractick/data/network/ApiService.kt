package com.example.rettrofitpractick.data.network

import com.example.rettrofitpractick.data.network.model.AuthRequestDtoModel
import com.example.rettrofitpractick.data.network.model.ListProductDtoModel
import com.example.rettrofitpractick.data.network.model.ProductDtoModel
import com.example.rettrofitpractick.data.network.model.UserDtoModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {


    @GET("/products/{id}")
    suspend fun getProduct (@Path("id") id: Int): ProductDtoModel


    @GET("/products")
    suspend fun getProducts(): ListProductDtoModel

    @POST("/auth/login")
    suspend fun auth(@Body authRequestDtoModel: AuthRequestDtoModel): UserDtoModel


}