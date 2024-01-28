package com.csmprojects.githubme.feature.profile

import com.csmprojects.githubme.core.common.model.ProfileDataModel


sealed interface ProfileUiState {
    /**
     * The data is still loading.
     */
    object Loading : ProfileUiState

    /**
     * The data is loaded successfully
     */
    data class Success(
        val data: ProfileDataModel,
    ) : ProfileUiState

    /**
     * The data is null
     */
    object Fail : ProfileUiState
}

