package com.csmprojects.githubme.core.data.di

import android.content.Context
import com.csmprojects.githubme.core.data.repository.DefaultLoginRepository
import com.csmprojects.githubme.core.data.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {
    @Provides
    @Singleton
    fun providesLoginRepository(
        @ApplicationContext context: Context
    ): LoginRepository {
        return DefaultLoginRepository(context)
    }
}