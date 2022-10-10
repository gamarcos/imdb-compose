package br.com.gabrielmarcos.imdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import br.com.gabrielmarcos.imdb.navigation.Navigator
import br.com.gabrielmarcos.imdb.navigation.NavigatorImpl
import br.com.gabrielmarcos.imdb.ui.theme.IMDBTheme

class MainActivity : ComponentActivity() {

    private lateinit var navigator: NavigatorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            navigator = NavigatorImpl(navController, this@MainActivity)
            MainApp(navigator = navigator)
        }
    }
}

@Composable
fun MainApp(navigator: Navigator) {
    val currentNavigator = remember { navigator }
    val currentScreen by currentNavigator.currentScreen.collectAsState()
    IMDBTheme {
        Surface { currentScreen() }
    }
}