package com.csmprojects.feature.login.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.csmprojects.core.common.model.NavigationRoutes
import com.csmprojects.feature.login.LoginRoute

val loginNavigationRoute = NavigationRoutes.LoginRoute.path

fun NavController.navigateToLoginScreen(url: String, navOptions: NavOptions? = null) {
    val encodedUrl = Uri.encode(url)
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(
) {
    composable(
        route = loginNavigationRoute,
    ) {
        LoginRoute()
    }
}
