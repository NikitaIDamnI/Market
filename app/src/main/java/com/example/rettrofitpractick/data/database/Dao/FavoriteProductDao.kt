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
    suspend fun removeFavoriteProduct(product: FavoriteProductDbModel)
/*
    @Query("SELECT * FROM favorite_products WHERE idUser = :userId")
    suspend fun getFavoriteProducts(userId: Int): List<FavoriteProductDbModel>

    @Query("SELECT * FROM favorite_products WHERE idUser = :userId AND idProduct = :productId")
    suspend fun isProductFavorite(userId: Int, productId: Int): Boolean

 */

}
