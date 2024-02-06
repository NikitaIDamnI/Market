package com.example.rettrofitpractick.data.network

import com.example.rettrofitpractick.data.network.model.ListProductDto
import com.example.rettrofitpractick.data.network.model.ProductDtoModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("/products/{id}")
    suspend fun getProduct (
        @Path("id") id: Int
    ): ProductDtoModel


    @GET("/products")
    suspend fun getProducts(

    ): ListProductDto



}