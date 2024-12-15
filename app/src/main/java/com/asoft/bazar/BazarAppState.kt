package com.asoft.bazar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.asoft.bazar.features.cart.CartDestination
import com.asoft.bazar.features.category.CategoryDestination
import com.asoft.bazar.features.home.HomeDestination
import com.asoft.bazar.features.profile.ProfileDestination
import com.asoft.bazar.features.signin.SignInDestination
import com.asoft.bazar.features.signup.SignUpDestination
import com.asoft.bazar.navigation.BazarNavigationDestination
import kotlinx.coroutines.CoroutineScope

@Stable
class BazarAppState(
    val coroutineScope: CoroutineScope,
    val navController: NavHostController,
    val startDestination: TopLevelDestination
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination
    private var _currentTopLevelDestination by mutableStateOf(startDestination)

    val currentTopLevelDestination: TopLevelDestination
        @Composable get() {
            topLevelDestinations.firstOrNull { it.route == currentDestination?.route }
                ?.let { _currentTopLevelDestination = it }
            return _currentTopLevelDestination
        }

    val topLevelDestinations = TopLevelDestination.entries.toTypedArray()

    val shouldShowBottomBar: Boolean
        @Composable get() = currentDestination?.route == currentTopLevelDestination.route

    fun navigate(destination: BazarNavigationDestination, route: String? = null) =
        with(navController) {
            if (destination is TopLevelDestination) {
                navigate(route ?: destination.route) {
                    // Pop up to the start destination of the graph to
                    // avoid building up a large stack of destinations
                    // on the back stack as users select items.
                    popUpTo(graph.findStartDestination().id) {
                        saveState = true
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item.
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item.
                    restoreState = true
                }
            } else {
                navigate(route ?: destination.route)
            }
        }

    fun onBackClick() = navController.popBackStack()
}

@Composable
fun rememberBazaarAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    startDestination: TopLevelDestination = TopLevelDestination.Home
) = remember(coroutineScope, navController, startDestination) {
    BazarAppState(coroutineScope, navController, startDestination)
}

enum class TopLevelDestination(
    override val route: String,
    override val destination: String,
    @DrawableRes val iconResourceId: Int,
    @StringRes val textResourceId: Int
) : BazarNavigationDestination {
    Home(
        route = HomeDestination.route,
        destination = HomeDestination.destination,
        iconResourceId = R.drawable.ic_ography_home_fill,
        textResourceId = R.string.home
    ),
    Category(
        route = CategoryDestination.route,
        destination = CategoryDestination.destination,
        iconResourceId = R.drawable.ic_ography_folder_fill,
        textResourceId = R.string.category
    ),
    Cart(
        route = CartDestination.route,
        destination = CartDestination.destination,
        iconResourceId = R.drawable.ic_ography_cart_fill,
        textResourceId = R.string.cart
    ),
    Profile(
        route = ProfileDestination.route,
        destination = ProfileDestination.destination,
        iconResourceId = R.drawable.ic_ography_profile_fill,
        textResourceId = R.string.profile
    ),
//    SignIn(
//        route = SignInDestination.route,
//        destination = SignInDestination.destination,
//        iconResourceId = R.drawable.ic_ography_fire,
//        textResourceId = R.string.sign_in
//    ),
//    SignUp(
//        route = SignUpDestination.route,
//        destination = SignUpDestination.destination,
//        iconResourceId = R.drawable.ic_ography_fire,
//        textResourceId = R.string.sign_up
//    )
}
