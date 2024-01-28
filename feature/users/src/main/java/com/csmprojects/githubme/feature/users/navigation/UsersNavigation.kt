package com.csmprojects.githubme.feature.users.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.csmprojects.githubme.core.common.model.NavigationRoutes
import com.csmprojects.githubme.feature.users.UsersRoute

val usersNavigationRoute = NavigationRoutes.UsersRoute.path

fun NavController.navigateToUsersScreen(navOptions: NavOptions? = null) {
    this.navigate(usersNavigationRoute, navOptions)
}

fun NavGraphBuilder.usersScreen(
    navigateToProfile: (loginId: String) -> Unit
) {
    composable(
        route = usersNavigationRoute,
    ) {
        UsersRoute(navigateToProfile)
    }
}