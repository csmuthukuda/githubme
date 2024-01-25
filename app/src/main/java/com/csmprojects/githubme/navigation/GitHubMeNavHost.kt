package com.csmprojects.githubme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.csmprojects.core.common.model.NavigationRoutes
import com.csmprojects.feature.login.navigation.loginScreen

@Composable
fun GitHubMeNavHost(
    navController: NavHostController,
    startDestination: String = NavigationRoutes.LoginRoute.path
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {

        loginScreen()

    }
}