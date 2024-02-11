package com.example.rettrofitpractick.domain.repository

import androidx.lifecycle.LiveData
import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User

interface LoginRepository {
    suspend fun authLogin(username: String, password: String): ResultAuth<User>
    suspend fun addUser(user: User)

    fun getUser(username: String): LiveData<User>

}