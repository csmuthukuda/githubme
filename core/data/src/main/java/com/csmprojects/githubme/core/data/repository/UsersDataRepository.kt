package com.csmprojects.githubme.core.data.repository

import com.csmprojects.githubme.core.common.model.UsersDataModel

interface UsersDataRepository {
    suspend fun getUsersData(): List<UsersDataModel>
}