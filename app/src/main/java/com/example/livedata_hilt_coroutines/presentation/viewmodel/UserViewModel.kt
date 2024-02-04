package com.example.livedata_hilt_coroutines.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livedata_hilt_coroutines.commons.result.Result
import com.example.livedata_hilt_coroutines.data.local.entity.UserEntity
import com.example.livedata_hilt_coroutines.domain.model.User
import com.example.livedata_hilt_coroutines.domain.usecase.GetAllUsersUseCase
import com.example.livedata_hilt_coroutines.domain.usecase.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val insertUseCase: InsertUserUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase
) :
    ViewModel() {
    private val _hasBeenInsert = MutableLiveData<Result<Unit>>()
    val hasBeenInsert: LiveData<Result<Unit>> = _hasBeenInsert

    val users: LiveData<List<UserEntity>> = getAllUsersUseCase()


    fun insertUser(user: User) {
        _hasBeenInsert.postValue(Result.Loading)

        viewModelScope.launch {
            try {
                insertUseCase(user)
                _hasBeenInsert.postValue(Result.Success(Unit))
            } catch (e: Exception) {
                _hasBeenInsert.postValue(Result.Error(e))
            }
        }
    }
}