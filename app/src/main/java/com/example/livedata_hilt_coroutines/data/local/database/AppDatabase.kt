package com.example.livedata_hilt_coroutines.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.livedata_hilt_coroutines.data.local.dao.UserDao
import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}