package com.example.rettrofitpractick.domain.useCase

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.repository.LoginRepository

class GetUserUseCase(
    private val repository: LoginRepository
) {
    operator fun invoke(username:String): LiveData<User> {
        return repository.getUser(username)
    }
}