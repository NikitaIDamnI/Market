package com.example.rettrofitpractick.data.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rettrofitpractick.data.database.model.FavoriteProductDbModel
import com.example.rettrofitpractick.data.database.model.ProductDbModel

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

    @Query("SELECT * FROM full_product_list LEFT JOIN favorite_products " +
            "ON full_product_list.id = favorite_products.product_id " +
        "AND favorite_products.user_id = :userId"
    )
    fun getProductByUserFavorite(userId: Int): LiveData<Map<ProductDbModel, FavoriteProductDbModel>>

}
