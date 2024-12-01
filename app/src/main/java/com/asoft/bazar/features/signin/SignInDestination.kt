package com.asoft.bazar.features.signin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asoft.bazar.navigation.BazarNavigationDestination

object SignInDestination : BazarNavigationDestination {
    override val route: String
        get() = "sign_in_route"
    override val destination: String
        get() = "sign_in_destination"
}

fun NavGraphBuilder.signinGraph() = composable(route = SignInDestination.route) {
    SignInScreen()
}
