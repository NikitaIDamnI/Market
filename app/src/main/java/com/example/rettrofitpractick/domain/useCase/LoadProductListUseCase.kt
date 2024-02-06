package com.example.rettrofitpractick.domain.useCase

import com.example.rettrofitpractick.domain.ProductRepository


class LoadProductListUseCase(
    private val repository: ProductRepository

) {
    suspend operator fun invoke(){
        repository.loadData()
    }
}