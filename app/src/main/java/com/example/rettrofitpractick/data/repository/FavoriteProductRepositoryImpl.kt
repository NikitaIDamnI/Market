package com.example.rettrofitpractick.data.repository

import android.app.Application
import com.example.rettrofitpractick.data.database.AppDatabase
import com.example.rettrofitpractick.domain.model.FavoriteProduct
import com.example.rettrofitpractick.domain.repository.FavoriteProductRepository

class FavoriteProductRepositoryImpl(
    private val application: Application
)
    :FavoriteProductRepository {

    val favoriteProductDao = AppDatabase.getInstance(application).favoriteProductDao()
    override suspend fun addFavoriteProduct(product: FavoriteProduct) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavoriteProduct(product: FavoriteProduct) {
        TODO("Not yet implemented")
    }

    override suspend fun getFavoriteProducts(userId: Int): List<FavoriteProduct> {
        TODO("Not yet implemented")
    }

    override suspend fun isProductFavorite(userId: Int, productId: Int): Boolean {
        TODO("Not yet implemented")
    }

}