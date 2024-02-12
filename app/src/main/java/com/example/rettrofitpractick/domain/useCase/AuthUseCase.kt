package com.example.rettrofitpractick.domain.useCase

import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.repository.LoginRepository

class AuthUseCase(
    private val repository: LoginRepository

) {

    suspend operator fun invoke(username:String, password : String): ResultAuth<User> {
        return repository.authLogin(username,password)
    }
}