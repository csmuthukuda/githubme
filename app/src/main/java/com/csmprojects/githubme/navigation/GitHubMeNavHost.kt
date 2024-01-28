package com.csmprojects.githubme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.csmprojects.githubme.core.common.model.NavigationRoutes
import com.csmprojects.githubme.feature.login.navigation.loginScreen
import com.csmprojects.githubme.feature.profile.navigation.navigateToProfileScreen
import com.csmprojects.githubme.feature.profile.navigation.profileScreen
import com.csmprojects.githubme.feature.users.navigation.navigateToUsersScreen
import com.csmprojects.githubme.feature.users.navigation.usersScreen

@Composable
fun GitHubMeNavHost(
    navController: NavHostController,
    startDestination: String = NavigationRoutes.LoginRoute.path
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {

        loginScreen(
            navigateToUsers = {
                navController.popBackStack()
                navController.navigateToUsersScreen()
            }
        )
        usersScreen(
            navigateToProfile = { loginId ->
                navController.navigateToProfileScreen(loginId)
            }
        )
        profileScreen(
            navigateToUsers = {
                navController.popBackStack(
                    route = NavigationRoutes.UsersRoute.path,
                    inclusive = true
                )
                navController.navigateToUsersScreen()
            }
        )

    }
}