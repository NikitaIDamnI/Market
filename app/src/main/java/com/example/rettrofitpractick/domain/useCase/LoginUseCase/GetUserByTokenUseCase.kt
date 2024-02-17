package com.example.rettrofitpractick.domain.useCase.LoginUseCase

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.repository.LoginRepository

data class GetUserByTokenUseCase (
    private val repository: LoginRepository
) {
     operator fun invoke(token:String): LiveData<User> {
        return repository.getUserByToken(token)
    }
}