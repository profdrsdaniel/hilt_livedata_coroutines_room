package com.example.livedata_hilt_coroutines.di

import com.example.livedata_hilt_coroutines.domain.repository.UserRepository
import com.example.livedata_hilt_coroutines.domain.usecase.GetAllUsersUseCase
import com.example.livedata_hilt_coroutines.domain.usecase.GetAllUsersUseCaseImpl
import com.example.livedata_hilt_coroutines.domain.usecase.InsertUserUseCase
import com.example.livedata_hilt_coroutines.domain.usecase.InsertUserUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesInsertUserUseCase(userRepository: UserRepository): InsertUserUseCase {
        return InsertUserUseCaseImpl(userRepository)
    }

    @Provides
    fun providesGetAllUsers(userRepository: UserRepository): GetAllUsersUseCase {
        return GetAllUsersUseCaseImpl(userRepository)
    }
}