package com.example.rettrofitpractick.domain.useCase.FavoriteProductUseCase

import com.example.rettrofitpractick.domain.model.FavoriteProduct
import com.example.rettrofitpractick.domain.repository.FavoriteProductRepository

class RemoveFavoriteProductUseCase(
    private val repository: FavoriteProductRepository

) {
    suspend operator fun invoke(product: FavoriteProduct) {
       return repository.removeFavoriteProduct(product)
    }
}