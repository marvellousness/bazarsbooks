package com.asoft.bazar.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.asoft.bazar.BazarAppState
import com.asoft.bazar.TopLevelDestination
import com.asoft.bazar.navigation.BazarNavHost
import com.asoft.bazar.rememberBazaarAppState

@Composable
fun BazarApp(
    appState: BazarAppState = rememberBazaarAppState(),
) {
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = appState.shouldShowBottomBar
            ) {
                BazarBottomBar(
                    destinations = appState.topLevelDestinations,
                    currentDestination = appState.currentTopLevelDestination,
                    onNavigateToDestination = appState::navigate

                )
            }
        }) { innerPadding ->
        BazarNavHost(
            navController = appState.navController,
            modifier = Modifier.padding(innerPadding),
            startDestination = appState.startDestination,
            onNavigateToDestination = appState::navigate,
            onBackClick = appState::onBackClick,
        )
    }
}

@Composable
private fun BazarBottomBar(
    destinations: Array<TopLevelDestination>,
    currentDestination: TopLevelDestination,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
) {
    NavigationBar {
        destinations.forEach { destination ->
            val selected = destination == currentDestination
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = destination.iconResourceId),
                        contentDescription = stringResource(id = destination.textResourceId)
                    )
                },
                label = { Text(stringResource(id = destination.textResourceId)) },
                selected = selected,
                onClick = {
                    onNavigateToDestination(destination)
                })
        }
    }
}