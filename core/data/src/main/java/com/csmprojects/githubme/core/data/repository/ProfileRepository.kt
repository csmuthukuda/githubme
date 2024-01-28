package com.csmprojects.githubme.core.data.repository

import com.csmprojects.githubme.core.common.model.ProfileDataModel

interface ProfileRepository {
    suspend fun getProfileData(loginId: String): ProfileDataModel?
}