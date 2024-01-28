package com.csmprojects.githubme.core.data.repository

import android.content.Intent
import android.content.IntentSender
import com.csmprojects.githubme.core.data.model.LogInResult

interface LoginRepository {
    suspend fun doLogIn(): IntentSender?
    suspend fun signInWithIntent(intent: Intent): LogInResult
    fun isSignedIn(): Boolean
}