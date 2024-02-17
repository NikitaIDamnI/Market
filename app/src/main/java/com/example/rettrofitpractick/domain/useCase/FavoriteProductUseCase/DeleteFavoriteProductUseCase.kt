package com.example.rettrofitpractick.domain.useCase.FavoriteProductUseCase

import com.example.rettrofitpractick.domain.repository.FavoriteProductRepository

class DeleteFavoriteProductUseCase ( private val repository: FavoriteProductRepository

) {
    suspend operator fun invoke(userId: Int,productId: Int){
        return repository.deleteFavoriteProduct(userId, productId)
    }
}