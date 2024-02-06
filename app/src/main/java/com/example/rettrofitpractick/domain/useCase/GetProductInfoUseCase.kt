package com.example.rettrofitpractick.domain.useCase

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.ProductRepository
import com.example.rettrofitpractick.domain.model.ProductModel

class GetProductInfoUseCase(
    private val repository: ProductRepository

) {
    operator fun invoke(id:Int): LiveData<ProductModel> {
       return repository.getProductInfo(id)
    }
}