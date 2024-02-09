package com.example.rettrofitpractick.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int ,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String
)
