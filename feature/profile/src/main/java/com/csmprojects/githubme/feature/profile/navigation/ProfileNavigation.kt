package com.csmprojects.githubme.feature.profile.navigation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.csmprojects.githubme.core.common.model.NavigationRoutes
import com.csmprojects.githubme.feature.profile.ProfileRoute

val profileNavigationRoute = NavigationRoutes.ProfileRoute.path
const val loginIdArg = "login"

fun NavController.navigateToProfileScreen(
    loginId: String,
    navOptions: NavOptions? = null
) {
    val encodedUrl = Uri.encode(loginId)
    this.navigate("$profileNavigationRoute/$encodedUrl", navOptions)
}

fun NavGraphBuilder.profileScreen(
    navigateToUsers: () -> Unit
) {
    composable(
        route = "$profileNavigationRoute/{$loginIdArg}",
        arguments = listOf(navArgument(loginIdArg) { type = NavType.StringType })
    ) {
        ProfileRoute(
            navigateToUsers = navigateToUsers
        )
    }
}

internal class LoginIdArg(val loginId: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(Uri.decode(checkNotNull(savedStateHandle[loginIdArg])))
}