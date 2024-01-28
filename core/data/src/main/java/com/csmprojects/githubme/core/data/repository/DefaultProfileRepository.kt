package com.csmprojects.githubme.core.data.repository

import com.csmprojects.githubme.core.common.model.ProfileDataModel
import com.csmprojects.githubme.core.data.model.asExternalModel
import com.csmprojects.githubme.core.data.remote.ProfileDataApi
import javax.inject.Inject

class DefaultProfileRepository @Inject constructor(
    private val api: ProfileDataApi
) : ProfileRepository {

    override suspend fun getProfileData(loginId: String): ProfileDataModel? {
        val response = api.getProfileData(loginId)
        return if (response.isSuccessful && response.body() != null) {
            response.body()?.asExternalModel()
        } else {
            null
        }
    }
}