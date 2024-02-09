package com.example.rettrofitpractick.domain.model

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class ResultAuth<out T : Any> {

    data class Success(val data: User) : ResultAuth<User>()
    data class Error(val exception: Exception) : ResultAuth<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}