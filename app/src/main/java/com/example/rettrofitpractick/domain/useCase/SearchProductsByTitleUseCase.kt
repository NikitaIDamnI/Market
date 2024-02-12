package com.example.rettrofitpractick.domain.useCase

import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.repository.ProductRepository

class SearchProductsByTitleUseCase(
    private val repository: ProductRepository

) { suspend operator fun invoke(query: String): List<ProductModel> {
        return repository.searchProductsByTitle(query)
    }
}