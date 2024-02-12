package com.example.rettrofitpractick.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rettrofitpractick.data.database.Dao.FavoriteProductDao
import com.example.rettrofitpractick.data.database.Dao.ProductDao
import com.example.rettrofitpractick.data.database.Dao.UserDao
import com.example.rettrofitpractick.data.database.model.FavoriteProductDbModel
import com.example.rettrofitpractick.data.database.model.ProductDbModel
import com.example.rettrofitpractick.data.database.model.UserDbModel

@Database(
    entities = [ProductDbModel::class,
        UserDbModel::class,
        FavoriteProductDbModel::class],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun productDao(): ProductDao
    abstract fun userDao(): UserDao
    abstract fun favoriteProductDao(): FavoriteProductDao

}
