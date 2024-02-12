package com.example.rettrofitpractick.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "full_product_list")

data class ProductDbModel(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: String,
    val favorite: Boolean = NOT_DETERMINED
) {
    companion object{
        const val NOT_DETERMINED = false
    }
}

