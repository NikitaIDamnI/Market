package com.example.rettrofitpractick.domain.repository

interface FavoriteProductRepository {
    suspend fun addFavoriteProduct(userId: Int,productId: Int, favoriteStatus :Boolean)

}