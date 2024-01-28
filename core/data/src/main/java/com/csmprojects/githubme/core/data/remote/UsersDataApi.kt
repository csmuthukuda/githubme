package com.csmprojects.githubme.core.data.remote

import com.csmprojects.githubme.core.data.model.UsersDataSource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface UsersDataApi {
    @GET
    suspend fun getUsersData(
        @Url url: String
    ): Response<List<UsersDataSource>>
}