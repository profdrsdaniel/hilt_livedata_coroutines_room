package com.example.livedata_hilt_coroutines.domain.usecase

import com.example.livedata_hilt_coroutines.domain.model.User
import com.example.livedata_hilt_coroutines.domain.model.toEntity
import com.example.livedata_hilt_coroutines.domain.repository.UserRepository
import javax.inject.Inject

interface InsertUserUseCase {
    suspend operator fun invoke(user: User)
}

class InsertUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    InsertUserUseCase {

    override suspend operator fun invoke(user: User) {
        userRepository.insertUser(user.toEntity())
    }
}