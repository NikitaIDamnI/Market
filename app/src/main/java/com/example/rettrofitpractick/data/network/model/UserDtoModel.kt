package com.example.rettrofitpractick.data.network.model

data class UserDtoModel(
    val id: Int,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String
)
