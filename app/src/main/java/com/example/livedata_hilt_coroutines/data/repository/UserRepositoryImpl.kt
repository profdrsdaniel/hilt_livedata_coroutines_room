package com.example.livedata_hilt_coroutines.data.repository

import com.example.livedata_hilt_coroutines.data.datasource.UserDataSource
import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity
import com.example.livedata_hilt_coroutines.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDataSource: UserDataSource) :
    UserRepository {

    override suspend fun insertUser(userEntity: UserEntity) = userDataSource.insertUser(userEntity)

    override fun getAllUser() =
        userDataSource.getAllUser()
}