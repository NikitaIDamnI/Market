package com.example.rettrofitpractick.domain.useCase

import com.example.rettrofitpractick.domain.ProductRepository
import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User

class AuthUseCase(
    private val repository: ProductRepository

) {

    suspend operator fun invoke(username:String, password : String): ResultAuth<User> {
        return repository.auth(username,password)
    }
}