package com.example.rettrofitpractick.presentation.ui.login_my

data class LoginStatus(
    var error : String = NO_ERROR,
    var authorizationStatus : Boolean = NOT_AUTHORIZED,
    var token : String = NOT_TOKEN
)
const val NO_ERROR = ""
const val NOT_AUTHORIZED = false
const val NOT_TOKEN = ""
