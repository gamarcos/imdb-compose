package br.com.gabrielmarcos.imdb.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.gabrielmarcos.imdb.DetailScreen
import br.com.gabrielmarcos.imdb.HomeScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface Navigator {
    val currentScreen: StateFlow<@Composable () -> Unit>
    fun onBackPressed(): Boolean
    fun performDetail()
}

class NavigatorImpl(
    private val navHost: NavHostController,
    private val context: Context
) : Navigator {

    private val initialScreen: @Composable () -> Unit = {
        AppNavigation(navHost = navHost, context = context, navigator = this)
    }

    private val _screenState = MutableStateFlow(initialScreen)
    override val currentScreen: StateFlow<() -> Unit> = _screenState

    override fun performDetail() {
        navHost.navigate("detail")
    }

    override fun onBackPressed(): Boolean = navHost.navigateUp()

}

@Composable
private fun AppNavigation(navHost: NavHostController, context: Context, navigator: Navigator) {
    NavHost(navController = navHost, startDestination = "home") {
        composable("home") { HomeScreen(context, navigator) }
        composable("detail") { DetailScreen() }

    }
}