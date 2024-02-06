package com.example.rettrofitpractick.domain.model

data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)
