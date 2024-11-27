package com.asoft.bazar.features.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asoft.bazar.navigation.BazarNavigationDestination

object ProfileDestination : BazarNavigationDestination {
    override val route: String
        get() = "profile_route"
    override val destination: String
        get() = "profile_destination"
}

fun NavGraphBuilder.profileGraph() = composable(route = ProfileDestination.route) {
    ProfileScreen()
}
