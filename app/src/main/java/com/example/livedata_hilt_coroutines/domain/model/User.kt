package com.example.livedata_hilt_coroutines.domain.model

import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity

data class User(val name: String)

fun User.toEntity() = UserEntity(name = this.name)

