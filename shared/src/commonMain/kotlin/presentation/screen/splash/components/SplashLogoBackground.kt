package presentation.screen.splash.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import presentation.theme.PaperHearts

@Composable
fun SplashLogoBackground() {
    Box {
        Image(
            modifier = Modifier
                .blur(
                    radius = 4.dp
                )
                .offset(
                    x = (-5).dp,
                    y = 4.dp,
                ),
            colorFilter = ColorFilter.tint(
                color = PaperHearts
            ),
            painter = painterResource(MR.images.ic_splash_logo_background),
            contentDescription = null
        )

        Image(
            modifier = Modifier
                .blur(
                    radius = 4.dp
                )
                .offset(
                    x = 0.dp,
                    y = 4.dp,
                ),
            colorFilter = ColorFilter.tint(
                color = PaperHearts
            ),
            painter = painterResource(MR.images.ic_splash_logo_background),
            contentDescription = null
        )

        Image(
            painter = painterResource(MR.images.ic_splash_logo_background),
            contentDescription = null
        )
    }
}