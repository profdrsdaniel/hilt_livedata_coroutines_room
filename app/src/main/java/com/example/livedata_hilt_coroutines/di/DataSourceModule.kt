package com.example.livedata_hilt_coroutines.di

import com.example.livedata_hilt_coroutines.data.datasource.UserDataSource
import com.example.livedata_hilt_coroutines.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideUserDataSource(userDao: UserDao): UserDataSource {
        return UserDataSource(userDao)
    }
}