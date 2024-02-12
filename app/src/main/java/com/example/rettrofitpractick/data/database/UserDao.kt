package com.example.rettrofitpractick.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun authUserToDb(user: UserDbModel)

    @Query("SELECT * FROM users WHERE username == :userName LIMIT 1")
   suspend fun getGetUser(userName: String ): UserDbModel

}