package com.example.rettrofitpractick.domain.model

data class FavoriteProduct(
    val id: Int,
    val idUser: Int,
    val idProduct: Int,
    val isFavorite: Boolean = NOT_DETERMINED
){
    companion object{
        const val NOT_DETERMINED = false
    }
}