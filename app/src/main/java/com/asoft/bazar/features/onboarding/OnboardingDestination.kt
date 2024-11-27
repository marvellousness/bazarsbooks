package com.asoft.bazar.features.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.asoft.bazar.navigation.BazarNavigationDestination

object OnboardingDestination : BazarNavigationDestination {
    override val route: String
        get() = "onboarding_route"
    override val destination: String
        get() = "onboarding_destination"
}

fun NavGraphBuilder.onboardingGraph() = composable(route = OnboardingDestination.route) {
    OnboardingScreen()
}
