package presentation.theme

import androidx.compose.ui.graphics.Color

sealed class ColorScheme(
    val colorTextPrimary: Color,
    val colorTextSecondary: Color,
    val colorBackground: Color,
    ) {
   data object Light: ColorScheme(
       colorTextPrimary = EerieBlack,
       colorTextSecondary = AmericanSilver,
       colorBackground = White,
   )

    data object Dark: ColorScheme(
        colorTextPrimary = EerieBlack,
        colorTextSecondary = AmericanSilver,
        colorBackground = White,
    )
}