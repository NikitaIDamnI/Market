package com.example.rettrofitpractick.domain.repository

import com.example.rettrofitpractick.domain.model.FavoriteProduct

interface FavoriteProductRepository {
    suspend fun addFavoriteProduct(product: FavoriteProduct)

    suspend fun removeFavoriteProduct(product: FavoriteProduct)

    suspend fun getFavoriteProducts(userId: Int): List<FavoriteProduct>

    suspend fun isProductFavorite(userId: Int, productId: Int): Boolean

}