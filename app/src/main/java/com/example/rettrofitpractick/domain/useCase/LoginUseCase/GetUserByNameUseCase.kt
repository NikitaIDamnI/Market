package com.example.rettrofitpractick.domain.useCase.LoginUseCase

import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.repository.LoginRepository

class GetUserByNameUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(username:String): User {
        return repository.getUserByName(username)
    }
}