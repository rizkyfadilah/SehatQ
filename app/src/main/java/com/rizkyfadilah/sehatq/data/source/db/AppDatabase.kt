package com.rizkyfadilah.sehatq.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rizkyfadilah.sehatq.domain.model.Product

@Database(entities = [Product::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "product.db"
        const val VERSION = 1
    }

    abstract fun productDao(): ProductDao
}