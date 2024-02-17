package com.example.rettrofitpractick.presentation.ui.login_my

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.rettrofitpractick.data.repository.LoginRepositoryImpl
import com.example.rettrofitpractick.domain.model.ResultAuth
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.domain.useCase.LoginUseCase.AuthUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = LoginRepositoryImpl(application)

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
                loginStatus.value = LoginStatus(authorizationStatus = true, user = result.data)
            }
            if(result is ResultAuth.Error){
                    loginStatus.value = LoginStatus(error = result.exception.toString())
                loadData.value = false
            }
        }
    }







}