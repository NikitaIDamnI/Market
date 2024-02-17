package com.example.rettrofitpractick.presentation.ui.login_my

import com.example.rettrofitpractick.domain.model.User

data class LoginStatus(
    var error : String = NO_ERROR,
    var authorizationStatus : Boolean = NOT_AUTHORIZED,
    var user : User ?= null
)
const val NO_ERROR = ""
const val NOT_AUTHORIZED = false

