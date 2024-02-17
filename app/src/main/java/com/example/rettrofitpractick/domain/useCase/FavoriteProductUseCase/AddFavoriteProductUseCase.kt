package com.example.rettrofitpractick.domain.useCase.FavoriteProductUseCase

import com.example.rettrofitpractick.domain.repository.FavoriteProductRepository

class AddFavoriteProductUseCase(
    private val repository: FavoriteProductRepository

) {
    suspend operator fun invoke(userId: Int,productId: Int, favoriteStatus :Boolean){
        return repository.addFavoriteProduct(userId,productId,favoriteStatus)
    }
}