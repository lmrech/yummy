package presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.icerockdev.library.MR
import dev.icerock.moko.resources.FontResource
import dev.icerock.moko.resources.compose.asFont

sealed class AppFontFamily(
    val fonts: List<AppFont>
) {
    data object NunitoSans : AppFontFamily(
        fonts = listOf(
            AppFont(
                fontResource = MR.fonts.NunitoSans.black,
                fontWeight = FontWeight.Black,
            ),
            AppFont(
                fontResource = MR.fonts.NunitoSans.bold,
                fontWeight = FontWeight.Bold,
            ),
            AppFont(
                fontResource = MR.fonts.NunitoSans.extraBold,
                fontWeight = FontWeight.ExtraBold,
            ),
            AppFont(
                fontResource = MR.fonts.NunitoSans.extraLight,
                fontWeight = FontWeight.ExtraLight,
            ),
            AppFont(
                fontResource = MR.fonts.NunitoSans.light,
                fontWeight = FontWeight.Light,
            ),
            AppFont(
                fontResource = MR.fonts.NunitoSans.medium,
                fontWeight = FontWeight.Medium,
            ),
            AppFont(
                fontResource = MR.fonts.NunitoSans.regular,
                fontWeight = FontWeight.Normal,
            ),
            AppFont(
                fontResource = MR.fonts.NunitoSans.semiBold,
                fontWeight = FontWeight.SemiBold,
            )
        )
    )

    @Composable
    fun toTextStyle(): TextStyle {
        return TextStyle(
            fontFamily = FontFamily(
                fonts = mutableListOf<Font>().apply {
                    fonts.forEach {
                        val font = it.asFont()
                        if (font != null) add(font)
                    }
                }
            )
        )
    }
}

data class AppFont(
    val fontResource: FontResource,
    val fontWeight: FontWeight = FontWeight.Normal,
    val fontStyle: FontStyle = FontStyle.Normal
) {
    @Composable
    fun asFont(): Font? {
        return this.fontResource.asFont(
            weight = fontWeight,
            style = fontStyle
        )
    }
}