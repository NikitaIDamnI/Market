package com.example.rettrofitpractick.presentation.ui.login_my

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rettrofitpractick.data.repository.ProductRepositoryImpl
import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.useCase.AuthUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = ProductRepositoryImpl(application)

    private val authUseCase = AuthUseCase(repository)


    var user = MutableLiveData<User>()
    var loginStatus  = MutableLiveData<LoginStatus>()
    var loadData = MutableLiveData<Boolean>()



    fun auth(username:String, password : String) {
        loadData.value = true
        viewModelScope.launch {
            val result = authUseCase(username, password)

            if (result is ResultAuth.Success){
                    user.value = result.data
                loadData.value = false
                loginStatus.value = LoginStatus(authorizationStatus = true, token = result.data.token)
            }
            if(result is ResultAuth.Error){
                    loginStatus.value = LoginStatus(error = result.exception.toString())
                loadData.value = false
            }
        }
    }







}