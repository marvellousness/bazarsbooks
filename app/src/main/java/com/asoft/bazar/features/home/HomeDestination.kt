package com.asoft.bazar.features.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asoft.bazar.model.MediaType
import com.asoft.bazar.navigation.BazarNavigationDestination

object HomeDestination : BazarNavigationDestination {
    override val route: String
        get() = "home_route"
    override val destination: String
        get() = "home_destination"
}

fun NavGraphBuilder.homeGraph(
    onNavigateToListDestination: (MediaType.Common) -> Unit,
) = composable(route = HomeDestination.route) {
    HomeRoute()
}
