package com.example.rettrofitpractick.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductDtoModel(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("price")
    @Expose
    val price: Int,
    @SerializedName("discountPercentage")
    @Expose
    val discountPercentage: Float,
    @SerializedName("rating")
    @Expose
    val rating: Float,
    @SerializedName("stock")
    @Expose
    val stock: Int,
    @SerializedName("brand")
    @Expose
    val brand: String,
    @SerializedName("category")
    @Expose
    val category: String,
    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String,
    @SerializedName("images")
    @Expose
    val images: List<String>
)
