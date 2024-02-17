package com.example.rettrofitpractick.data.mappers


import com.example.rettrofitpractick.data.database.model.FavoriteProductDbModel
import com.example.rettrofitpractick.data.database.model.ProductDbModel
import com.example.rettrofitpractick.data.network.model.ProductDtoModel
import com.example.rettrofitpractick.domain.model.ProductModel

class ProductMapper {
    fun mapDtoToDbModel(dto: ProductDtoModel) = ProductDbModel(
        id = dto.id,
        title = dto.title,
        description = dto.description,
        price = dto.price,
        discountPercentage = dto.discountPercentage,
        rating = dto.rating,
        stock = dto.stock,
        brand = dto.brand,
        category = dto.category,
        thumbnail = dto.thumbnail,
        images = listToSting(dto.images)
    )


    private fun listToSting(list: List<String>): String {
        return list.joinToString(",")
    }

    fun stingToList(stringList: String): List<String> {
        return stringList.split(",")
    }


    fun mapDbModelToEntity(dbModel: ProductDbModel) = ProductModel(
        id = dbModel.id,
        title = dbModel.title,
        description = dbModel.description,
        price = dbModel.price,
        discountPercentage = dbModel.discountPercentage,
        rating = dbModel.rating,
        stock = dbModel.stock,
        brand = dbModel.brand,
        category = dbModel.category,
        thumbnail = dbModel.thumbnail,
        images = stingToList(dbModel.images)
    )

    fun mapDbModelListToEntityList(dbModelList: List<ProductDbModel>) =
        dbModelList.map { mapDbModelToEntity(it) }

    fun mapDtoListToDbList(dbModelList: List<ProductDtoModel>) =
        dbModelList.map { mapDtoToDbModel(it) }


    fun mapDbFavoriteProductToUserModel(mapProduct: Map<ProductDbModel, FavoriteProductDbModel>): List<ProductModel> {
        val favoriteList = mapProduct.map { entities ->
            val product = entities.key
            val favorite = entities.value
            val favoriteStatus = if(favorite == null){
                false
            }else{
                favorite.isFavorite
            }
            ProductModel(
                id = product.id,
                title = product.title,
                description = product.description,
                price = product.price,
                discountPercentage = product.discountPercentage,
                rating = product.rating,
                stock = product.stock,
                brand = product.brand,
                category = product.category,
                thumbnail = product.thumbnail,
                images = stingToList(product.images),
                favorite = favoriteStatus
            )
        }
        return favoriteList

    }
}