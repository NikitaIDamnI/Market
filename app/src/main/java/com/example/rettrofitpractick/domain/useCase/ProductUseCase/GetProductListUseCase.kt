package com.example.rettrofitpractick.domain.useCase.ProductUseCase

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.repository.ProductRepository

class GetProductListUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(): LiveData<List<ProductModel>> {
       return repository.getProductList()
    }
}