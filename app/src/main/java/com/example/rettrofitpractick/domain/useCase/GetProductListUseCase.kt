package com.example.rettrofitpractick.domain.useCase

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.data.repository.ProductRepositoryImpl
import com.example.rettrofitpractick.domain.ProductRepository
import com.example.rettrofitpractick.domain.model.ProductModel

class GetProductListUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(): LiveData<List<ProductModel>> {
       return repository.getProductList()
    }
}