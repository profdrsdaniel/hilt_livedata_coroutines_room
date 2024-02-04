package com.example.livedata_hilt_coroutines.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.livedata_hilt_coroutines.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)

fun UserEntity.toDomain() = User(this.name)
