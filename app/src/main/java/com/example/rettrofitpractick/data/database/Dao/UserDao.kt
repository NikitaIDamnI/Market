package com.example.rettrofitpractick.data.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rettrofitpractick.data.database.model.UserDbModel

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun authUserToDb(user: UserDbModel)

    @Query("SELECT * FROM users WHERE username == :userName LIMIT 1")
   suspend fun getUserByName(userName: String ): UserDbModel

    @Query("SELECT * FROM users WHERE token == :token LIMIT 1")
   fun getUserByToken(token: String ): LiveData<UserDbModel>


   
   

}