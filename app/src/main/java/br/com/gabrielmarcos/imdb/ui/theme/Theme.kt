package br.com.gabrielmarcos.imdb.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Background,
    surface = Background,
    onPrimary = BrandOnPrimary,
    onSecondary = BrandOnPrimary,
    onBackground = BrandOnPrimary,
    onSurface = BrandOnPrimary,
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Background,
    surface = Background,
    onPrimary = BrandOnPrimary,
    onSecondary = BrandOnPrimary,
    onBackground = BrandOnPrimary,
    onSurface = BrandOnPrimary,
)

@Composable
fun IMDBTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}