package com.csmprojects.githubme.core.data.repository.fake

import android.content.Intent
import android.content.IntentSender
import com.csmprojects.githubme.core.data.model.LogInResult
import com.csmprojects.githubme.core.data.model.UserData
import com.csmprojects.githubme.core.data.repository.LoginRepository

class FakeLoginRepository : LoginRepository {

    override suspend fun doLogIn(): IntentSender? {
        return null
    }

    override suspend fun signInWithIntent(intent: Intent): LogInResult {
        return LogInResult(
            data = getFakeUserData(),
            errorMessage = null
        )
    }

    override fun isSignedIn(): Boolean {
        return true
    }

    fun getFakeUserData(): UserData {
        return UserData(
            profilePictureUrl = "url",
            userId = "1",
            username = "testUser"
        )
    }
}