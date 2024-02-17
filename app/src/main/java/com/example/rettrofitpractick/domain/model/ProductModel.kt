package com.example.rettrofitpractick.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val id: Int,
    val title: String, // название
    val description: String, //описание
    val price: Int,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>,
    val favorite: Boolean = NOT_DETERMINED
) : Parcelable {
    companion object {

        const val NOT_DETERMINED = false
    }
}

