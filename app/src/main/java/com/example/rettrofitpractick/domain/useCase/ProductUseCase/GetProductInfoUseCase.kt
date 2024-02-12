package com.example.rettrofitpractick.domain.useCase.ProductUseCase

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.repository.ProductRepository

class GetProductInfoUseCase(
    private val repository: ProductRepository

) {
    operator fun invoke(id:Int): LiveData<ProductModel> {
       return repository.getProductInfo(id)
    }
}