package com.csmprojects.githubme.feature.users

import com.csmprojects.githubme.core.common.model.UsersDataModel


sealed interface UsersUiState {
    /**
     * The data is still loading.
     */
    object Loading : UsersUiState

    /**
     * The data is loaded successfully
     */
    data class Success(

        val usersData: List<UsersDataModel>,
    ) : UsersUiState

    /**
     * The data is null
     */
    object Fail : UsersUiState
}

