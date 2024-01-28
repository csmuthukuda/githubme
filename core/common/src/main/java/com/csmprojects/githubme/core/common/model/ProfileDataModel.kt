package com.csmprojects.githubme.core.common.model

data class ProfileDataModel(
    val login: String?,
    val id: Int? = null,
    val avatarUrl: String? = null,
    val url: String? = null,
    val htmlUrl: String? = null,
    val type: String? = null,
    val name: String? = null,
    val company: String? = null,
    val blog: String? = null,
    val location: String? = null,
    val email: String? = null,
    val hireable: String? = null,
    val bio: String? = null,
    val twitterUsername: String? = null,
    val publicRepos: Int? = null,
    val publicGists: Int? = null,
    val followers: Int? = null,
    val following: Int? = null,
    val createdAt: String? = null,
)
