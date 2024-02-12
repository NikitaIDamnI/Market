package com.example.rettrofitpractick.domain.repository

import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User

interface LoginRepository {
    suspend fun authLogin(username: String, password: String): ResultAuth<User>
    suspend fun addUser(user: User)

    suspend fun getUser(username: String): User

}