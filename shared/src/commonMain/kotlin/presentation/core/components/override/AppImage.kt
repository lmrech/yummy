package presentation.core.components.override

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import presentation.theme.Black

@Composable
fun AppImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    shadow: AppShadow? = null,
) {
    Box {
        shadow?.let {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = modifier
                    .blur(
                        radius = it.blur
                    )
                    .offset(
                        x = it.x,
                        y = it.y,
                    ),
                alignment = alignment,
                contentScale = contentScale,
                alpha = alpha,
                colorFilter = ColorFilter.tint(
                    color = it.color
                )
            )
        }

        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter
        )
    }
}

data class AppShadow(
    val color: Color = Black
        .copy(alpha = 0.25f),
    val x: Dp = 0.dp,
    val y: Dp = 0.dp,
    val blur: Dp = 0.dp
)