package com.rizkyfadilah.sehatq.di.module

import android.app.Application
import androidx.room.Room
import com.rizkyfadilah.sehatq.data.source.db.AppDatabase
import com.rizkyfadilah.sehatq.data.source.db.ProductDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
                .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    fun provideProductDao(appDataBase: AppDatabase): ProductDao {
        return appDataBase.productDao()
    }
}