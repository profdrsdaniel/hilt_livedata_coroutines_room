package com.example.livedata_hilt_coroutines.domain.repository

import androidx.lifecycle.LiveData
import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity

interface UserRepository {
    suspend fun insertUser(userEntity: UserEntity)
    fun getAllUser(): LiveData<List<UserEntity>>
}