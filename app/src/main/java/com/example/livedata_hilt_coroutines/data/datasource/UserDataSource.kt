package com.example.livedata_hilt_coroutines.data.datasource

import androidx.lifecycle.LiveData
import com.example.livedata_hilt_coroutines.data.local.dao.UserDao
import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserDataSource @Inject constructor(private val dao: UserDao) {

    suspend fun insertUser(userEntity: UserEntity) = withContext(Dispatchers.IO) {
        dao.insertUser(userEntity)
    }

    fun getAllUser(): LiveData<List<UserEntity>> = dao.getAllUsers()
}