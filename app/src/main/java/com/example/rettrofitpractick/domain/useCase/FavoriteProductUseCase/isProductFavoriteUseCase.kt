package com.example.rettrofitpractick.domain.useCase.FavoriteProductUseCase

import com.example.rettrofitpractick.domain.repository.FavoriteProductRepository

class isProductFavoriteUseCase(
    private val repository: FavoriteProductRepository

) {
    suspend operator fun invoke(userId: Int, productId: Int): Boolean {
       return repository.isProductFavorite(userId, productId)
    }
}