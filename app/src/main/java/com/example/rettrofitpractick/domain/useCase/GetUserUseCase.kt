package com.example.rettrofitpractick.domain.useCase

import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.repository.LoginRepository

class GetUserUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(username:String): User {
        return repository.getUser(username)
    }
}