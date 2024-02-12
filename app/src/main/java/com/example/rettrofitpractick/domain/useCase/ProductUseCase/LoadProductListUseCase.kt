package com.example.rettrofitpractick.domain.useCase.ProductUseCase

import com.example.rettrofitpractick.domain.repository.ProductRepository


class LoadProductListUseCase(
    private val repository: ProductRepository

) {
    suspend operator fun invoke(){
        repository.loadData()
    }
}