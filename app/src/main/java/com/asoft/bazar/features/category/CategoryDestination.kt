package com.asoft.bazar.features.category

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asoft.bazar.navigation.BazarNavigationDestination

object CategoryDestination : BazarNavigationDestination {
    override val route: String
        get() = "category_route"
    override val destination: String
        get() = "category_destination"
}

fun NavGraphBuilder.categoryGraph() = composable(route = CategoryDestination.route) {
    CategoryScreen()
}
