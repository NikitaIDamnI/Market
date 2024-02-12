package com.example.rettrofitpractick.data.mappers


import com.example.rettrofitpractick.data.database.model.ProductDbModel
import com.example.rettrofitpractick.data.network.model.ProductDtoModel
import com.example.rettrofitpractick.data.network.model.UserDtoModel
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.domain.model.User
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

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


    private fun convertTimestampToTime(timestamp: Long?): String {
        if (timestamp == null) return ""
        val stamp = Timestamp(timestamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.timeZone = TimeZone.getDefault()
        return sdf.format(date)
    }

    fun mapDtoUserToDbModelUser(dto: UserDtoModel) = User(
        id = dto.id,
        username = dto.username,
        email = dto.email,
        firstName = dto.firstName,
        lastName = dto.lastName,
        gender = dto.gender,
        image = dto.image,
        token = dto.token

    )

}