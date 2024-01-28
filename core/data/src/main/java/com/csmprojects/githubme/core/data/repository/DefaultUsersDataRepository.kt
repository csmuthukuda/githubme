package com.csmprojects.githubme.core.data.repository

import com.csmprojects.githubme.core.common.model.UsersDataModel
import com.csmprojects.githubme.core.data.model.UsersDataSource
import com.csmprojects.githubme.core.data.model.asExternalModel
import com.csmprojects.githubme.core.data.remote.UsersDataApi
import javax.inject.Inject

class DefaultUsersDataRepository @Inject constructor(
    private val api: UsersDataApi
) : UsersDataRepository {
    override suspend fun getUsersData(): List<UsersDataModel> {
        val response = api.getUsersData("users")
        return if (response.isSuccessful && response.body() != null) {
            response.body()?.map(UsersDataSource::asExternalModel) ?: emptyList()
        } else {
            emptyList()
        }
    }
}