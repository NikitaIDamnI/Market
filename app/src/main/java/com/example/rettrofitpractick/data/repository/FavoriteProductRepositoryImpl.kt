package com.example.rettrofitpractick.data.repository

import android.app.Application
import com.example.rettrofitpractick.data.database.AppDatabase
import com.example.rettrofitpractick.data.database.model.FavoriteProductDbModel
import com.example.rettrofitpractick.domain.repository.FavoriteProductRepository

class FavoriteProductRepositoryImpl(
    private val application: Application
) :FavoriteProductRepository {

    private val favoriteProductDao = AppDatabase.getInstance(application).favoriteProductDao()
    override suspend fun addFavoriteProduct(userId: Int,productId: Int, favoriteStatus :Boolean) {
        favoriteProductDao.addFavoriteProduct(FavoriteProductDbModel(
            idUser = userId,
            idProduct = productId,
            isFavorite = favoriteStatus
        ))
    }


}