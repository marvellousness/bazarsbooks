package com.asoft.bazar.features.cart

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asoft.bazar.navigation.BazarNavigationDestination

object CartDestination : BazarNavigationDestination {
    override val route: String
        get() = "cart_route"
    override val destination: String
        get() = "cart_destination"
}

fun NavGraphBuilder.cartGraph() = composable(route = CartDestination.route) {
    CartScreen()
}
