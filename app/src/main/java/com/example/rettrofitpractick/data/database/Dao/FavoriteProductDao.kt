package com.example.rettrofitpractick.data.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.rettrofitpractick.data.database.model.FavoriteProductDbModel

@Dao
interface FavoriteProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteProduct(product: FavoriteProductDbModel)
    @Delete
    suspend fun deleteFavoriteProduct(product: FavoriteProductDbModel)

}
