package com.example.livedata_hilt_coroutines.di

import com.example.livedata_hilt_coroutines.data.datasource.UserDataSource
import com.example.livedata_hilt_coroutines.data.repository.UserRepositoryImpl
import com.example.livedata_hilt_coroutines.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }
}