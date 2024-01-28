package com.csmprojects.githubme.feature.login

import android.content.Intent
import android.content.IntentSender
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csmprojects.githubme.core.data.model.UserData
import com.csmprojects.githubme.core.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Loading)
    val loginUiState = _loginUiState.asStateFlow()

    private fun logInSuccess(userData: UserData) {
        _loginUiState.value = LoginUiState.Success(userData)
    }

    fun logInFailed() {
        _loginUiState.value = LoginUiState.Fail
    }

    suspend fun initLogIn(): IntentSender? {
        _loginUiState.value = LoginUiState.Loading
        return viewModelScope.async {
            loginRepository.doLogIn()
        }.await()
    }

    fun isSignedIn(): Boolean {
        return loginRepository.isSignedIn()
    }


    fun saveSignInData(data: Intent) {
        viewModelScope.launch {
            val userData = loginRepository.signInWithIntent(data)
            userData.data?.let { data ->
                logInSuccess(data)
            }

        }

    }


}