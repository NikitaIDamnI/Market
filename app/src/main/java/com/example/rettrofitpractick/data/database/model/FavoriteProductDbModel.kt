package com.example.rettrofitpractick.data.database.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "favorite_products",
    primaryKeys = ["user_id", "product_id"],
    foreignKeys = [ForeignKey(
        entity = UserDbModel::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    ), ForeignKey(
        entity = ProductDbModel::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("product_id"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE

    )],


    )
@Parcelize
data class FavoriteProductDbModel(
    @ColumnInfo("user_id") val idUser: Int,
    @ColumnInfo("product_id") val idProduct: Int,
    @ColumnInfo("is_favorite") val isFavorite:Boolean
) : Parcelable
