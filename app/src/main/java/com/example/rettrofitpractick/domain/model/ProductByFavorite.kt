package com.example.rettrofitpractick.domain.model

data class ProductByFavorite (
    val id :Int,
    val title: String,
    val price: Int,
    val images: List<String>,
    val favorite: Boolean = ProductModel.NOT_DETERMINED
    )
