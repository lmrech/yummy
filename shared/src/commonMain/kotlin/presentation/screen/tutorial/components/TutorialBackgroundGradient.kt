package presentation.screen.tutorial.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import presentation.screen.tutorial.TutorialScreen
import presentation.theme.PinkPerfume
import presentation.theme.Transparent

@Composable
fun TutorialScreen.TutorialBackgroundGradient(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(256.dp)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            PinkPerfume.copy(
                                alpha = 0.85f
                            ),
                            Transparent
                        )
                    )
                )
        )
    }
}