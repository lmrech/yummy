package presentation.theme

data class StyleSheet(
    val colorScheme: ColorScheme = ColorScheme.Light,
    val fontFamily: AppFontFamily = AppFontFamily.NunitoSans,
)