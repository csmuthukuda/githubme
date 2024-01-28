package com.csmprojects.githubme.core.data.remote

import com.csmprojects.githubme.core.data.model.ProfileDataSource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileDataApi {
    @GET("users/{user}")
    suspend fun getProfileData(
        @Path("user") user: String
    ): Response<ProfileDataSource>
}