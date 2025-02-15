package com.csmprojects.githubme.core.data.di

import com.csmprojects.githubme.core.data.remote.ProfileDataApi
import com.csmprojects.githubme.core.data.repository.DefaultProfileRepository
import com.csmprojects.githubme.core.data.repository.ProfileRepository
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
object ProfileModule {
    @Provides
    @Singleton
    fun provideProfileDataApi(): ProfileDataApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(ProfileDataApi::class.java)
    }

    @Provides
    @Singleton
    fun providesProfileDataRepository(
        api: ProfileDataApi
    ): ProfileRepository {
        return DefaultProfileRepository(api)
    }
}