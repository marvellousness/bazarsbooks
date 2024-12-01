package com.asoft.bazar.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import com.asoft.bazar.features.cart.cartGraph
import com.asoft.bazar.features.category.categoryGraph
import com.asoft.bazar.features.home.homeGraph
import com.asoft.bazar.features.profile.profileGraph
import com.asoft.bazar.features.signin.signinGraph

@Composable
fun BazarNavHost(
    navController: NavHostController,
    startDestination: BazarNavigationDestination,
    onNavigateToDestination: (BazarNavigationDestination, String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.route
    ) {
        homeGraph(
            onNavigateToListDestination = {
                onNavigateToDestination
            }
        )
        categoryGraph()
        cartGraph()
        profileGraph()
        signinGraph()
    }
}