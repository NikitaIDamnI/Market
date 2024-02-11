package com.example.rettrofitpractick.domain.useCase

import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.repository.LoginRepository

class AddUserUseCase(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(user: User) {
        repository.addUser(user)
    }
}