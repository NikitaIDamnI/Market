package com.example.rettrofitpractick.domain.useCase.FavoriteProductUseCase

import com.example.rettrofitpractick.domain.model.FavoriteProduct
import com.example.rettrofitpractick.domain.repository.FavoriteProductRepository

class GetFavoriteProductsUseCase(
    private val repository: FavoriteProductRepository

) {
   suspend operator fun invoke(id: Int): List<FavoriteProduct>{
       return repository.getFavoriteProducts(id)
    }
}