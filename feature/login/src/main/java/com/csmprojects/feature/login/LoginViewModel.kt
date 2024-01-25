package com.csmprojects.feature.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Loading)
    val loginUiState = _loginUiState.asStateFlow()

    init {
    }

}