package com.csmprojects.feature.login


sealed interface LoginUiState {
    /**
     * The data is still loading.
     */
    object Loading : LoginUiState

    /**
     * The data is loaded successfully
     */
//    data class Success(
//
//        val weatherData: WeatherDataResource,
//        val uiLayout: LayoutStructure
//    ) : LoginUiState

    /**
     * The data is null
     */
    object Fail : LoginUiState
}

