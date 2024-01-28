package com.csmprojects.githubme.feature.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.csmprojects.githubme.core.common.model.NavigationRoutes
import com.csmprojects.githubme.feature.login.LoginRoute

val loginNavigationRoute = NavigationRoutes.LoginRoute.path
fun NavGraphBuilder.loginScreen(
    navigateToUsers: () -> Unit
) {
    composable(
        route = loginNavigationRoute,
    ) {
        LoginRoute(navigateToUsers = navigateToUsers)
    }
}
