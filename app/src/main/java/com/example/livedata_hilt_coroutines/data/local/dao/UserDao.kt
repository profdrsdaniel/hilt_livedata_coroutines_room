package com.example.livedata_hilt_coroutines.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Query("Select * from user")
    fun getAllUsers(): LiveData<List<UserEntity>>
}