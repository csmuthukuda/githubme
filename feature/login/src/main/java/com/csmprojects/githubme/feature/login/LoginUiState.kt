package com.csmprojects.githubme.feature.login

import com.csmprojects.githubme.core.data.model.UserData


sealed interface LoginUiState {
    /**
     * The data is still loading.
     */
    object Loading : LoginUiState

    /**
     * login successfully
     */
    data class Success(
        val data: UserData,
    ) : LoginUiState

    /**
     * The data is null
     */
    object Fail : LoginUiState
}

