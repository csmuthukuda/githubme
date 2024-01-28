package com.csmprojects.githubme.feature.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csmprojects.githubme.core.data.repository.ProfileRepository
import com.csmprojects.githubme.feature.profile.navigation.LoginIdArg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val profileRepository: ProfileRepository
) : ViewModel() {
    private val loginIdArg = LoginIdArg(savedStateHandle)

    private val _profileUiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val profileUiState = _profileUiState.asStateFlow()

    init {
        viewModelScope.launch {
            _profileUiState.value = ProfileUiState.Loading
            val data = profileRepository.getProfileData(loginIdArg.loginId)
            if (data != null) {
                _profileUiState.value = ProfileUiState.Success(data)
            } else {
                _profileUiState.value = ProfileUiState.Fail
            }
        }

    }
}
