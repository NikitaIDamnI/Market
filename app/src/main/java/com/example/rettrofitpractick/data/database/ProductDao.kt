package com.example.rettrofitpractick.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM full_product_list ")
    fun getProductList(): LiveData<List<ProductDbModel>>

    @Query("SELECT * FROM full_product_list WHERE id == :id LIMIT 1")
    fun getProductInfo(id: Int): LiveData<ProductDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductList(priceList: List<ProductDbModel>)

    @Query("SELECT COUNT(*) FROM full_product_list ")
    suspend fun getProductCount(): Int


    @Query("SELECT * FROM full_product_list WHERE title LIKE '%' || :query || '%'")
    suspend fun searchProductsByTitle(query: String): List<ProductDbModel>



}
