package com.csmprojects.githubme.core.data.di

import com.csmprojects.githubme.core.data.remote.UsersDataApi
import com.csmprojects.githubme.core.data.repository.DefaultUsersDataRepository
import com.csmprojects.githubme.core.data.repository.UsersDataRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UsersModule {
    @Provides
    @Singleton
    fun provideUsersDataApi(): UsersDataApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(UsersDataApi::class.java)
    }

    @Provides
    @Singleton
    fun providesUsersDataRepository(
        api: UsersDataApi
    ): UsersDataRepository {
        return DefaultUsersDataRepository(api)
    }
}