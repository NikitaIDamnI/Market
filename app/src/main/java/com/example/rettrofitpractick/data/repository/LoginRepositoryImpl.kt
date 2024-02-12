package com.example.rettrofitpractick.data.repository

import android.app.Application
import android.util.Log
import com.example.rettrofitpractick.data.database.AppDatabase
import com.example.rettrofitpractick.data.mappers.UserMapper
import com.example.rettrofitpractick.data.network.ApiFactory
import com.example.rettrofitpractick.data.network.model.AuthRequestDtoModel
import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.repository.LoginRepository
import java.io.IOException

class LoginRepositoryImpl(
    private val application: Application
): LoginRepository {

    private val apiService = ApiFactory.apiService
    private val mapper = UserMapper()
    private val userDao = AppDatabase.getInstance(application).userDao()


    override suspend fun authLogin(username: String, password: String): ResultAuth<User> {
        val userFromDatabase = userDao.getGetUser(username)
        Log.d("LoginRepositoryImpl", "userFromDatabase| $userFromDatabase")
        if (userFromDatabase != null) {
            return ResultAuth.Success(mapper.mapDbUserToUser(userFromDatabase))
        } else {
            try {
                userDao.getGetUser(username)
                val userDto = apiService.auth(
                    AuthRequestDtoModel(
                        username,
                        password
                    )
                )

                val userDb = mapper.mapDtoUserToUserDbModel(userDto)
                userDao.authUserToDb(userDb)
                val userModel = mapper.mapDtoUserToUserModel(userDto)
                return ResultAuth.Success(userModel)
            } catch (e: Exception) {
                return ResultAuth.Error(IOException("Error logging in", e))
            }
        }
    }

    override suspend fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(username: String): User {
        TODO("Not yet implemented")
    }
}