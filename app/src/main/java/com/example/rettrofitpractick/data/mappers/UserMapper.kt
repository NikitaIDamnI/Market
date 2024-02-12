package com.example.rettrofitpractick.data.mappers

import com.example.rettrofitpractick.data.database.model.UserDbModel
import com.example.rettrofitpractick.data.network.model.UserDtoModel
import com.example.rettrofitpractick.domain.model.User

class UserMapper {
    fun mapDtoUserToUserModel(dto: UserDtoModel) = User(
        id = dto.id,
        username = dto.username,
        email = dto.email,
        firstName = dto.firstName,
        lastName = dto.lastName,
        gender = dto.gender,
        image = dto.image,
        token = dto.token

    )

    fun mapDtoUserToUserDbModel(dto: UserDtoModel) = UserDbModel(
        id = dto.id,
        username = dto.username,
        email = dto.email,
        firstName = dto.firstName,
        lastName = dto.lastName,
        gender = dto.gender,
        image = dto.image,
        token = dto.token

    )

    fun mapDbUserToUser(db: UserDbModel) = User(
        id = db.id,
        username = db.username,
        email = db.email,
        firstName = db.firstName,
        lastName = db.lastName,
        gender = db.gender,
        image = db.image,
        token = db.token

    )

    fun mapUserToUserDbModel(user: User) = UserDbModel(
        id = user.id,
        username = user.username,
        email = user.email,
        firstName = user.firstName,
        lastName = user.lastName,
        gender = user.gender,
        image = user.image,
        token = user.token

    )

}