package com.example.rettrofitpractick.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ListProductDto {
    @SerializedName("products")
    @Expose
    val productModels: List<ProductDtoModel>? = null
}