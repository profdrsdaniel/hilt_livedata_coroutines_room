package com.example.livedata_hilt_coroutines.domain.usecase

import androidx.lifecycle.LiveData
import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity
import com.example.livedata_hilt_coroutines.domain.repository.UserRepository
import javax.inject.Inject

interface GetAllUsersUseCase {
    operator fun invoke(): LiveData<List<UserEntity>>
}

class GetAllUsersUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    GetAllUsersUseCase {

    override operator fun invoke() =
        userRepository.getAllUser()
}