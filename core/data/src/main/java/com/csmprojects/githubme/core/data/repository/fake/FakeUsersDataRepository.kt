package com.csmprojects.githubme.core.data.repository.fake

import com.csmprojects.githubme.core.common.model.UsersDataModel
import com.csmprojects.githubme.core.data.repository.UsersDataRepository

class FakeUsersDataRepository : UsersDataRepository {
    private var setListEmpty = false
    override suspend fun getUsersData(): List<UsersDataModel> {
        if (setListEmpty) {
            return emptyList()
        } else {
            return listOf(getTestData())
        }

    }

    fun setListEmpty(value: Boolean) {
        setListEmpty = value
    }

    fun getTestData(): UsersDataModel {
        return UsersDataModel(
            login = "testLogin",
            avatarUrl = "testAvatarUrl",
            htmlUrl = "testHtmlUrl"
        )
    }
}