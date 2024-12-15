package com.asoft.bazar.features.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asoft.bazar.navigation.BazarNavigationDestination

object SignUpDestination : BazarNavigationDestination {
    override val route: String
        get() = "sign_up_route"
    override val destination: String
        get() = "sign_up_destination"
}

fun NavGraphBuilder.signupGraph() = composable(route = SignUpDestination.route) {
    SignUpScreen()
}
