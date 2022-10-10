package br.com.gabrielmarcos.imdb.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.gabrielmarcos.imdb.R

// Set of Material typography styles to start with

val Gilroy = FontFamily(
    Font(R.font.gilroy_light),
    Font(R.font.gilroy_extra_bold, FontWeight.ExtraBold)
)

val Typography = Typography(
    h2 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp
    ),
    body1 = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)