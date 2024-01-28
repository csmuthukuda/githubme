package com.csmprojects.githubme.feature.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csmprojects.githubme.core.data.repository.UsersDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersDataRepository: UsersDataRepository
) : ViewModel() {
    private val _usersUiState = MutableStateFlow<UsersUiState>(UsersUiState.Loading)
    val usersUiState = _usersUiState.asStateFlow()

    init {
        viewModelScope.launch {
            _usersUiState.value = UsersUiState.Loading
            val data = usersDataRepository.getUsersData()
            if (data.isNotEmpty()) {
                _usersUiState.value = UsersUiState.Success(data)
            } else {
                _usersUiState.value = UsersUiState.Fail
            }
        }

    }

}