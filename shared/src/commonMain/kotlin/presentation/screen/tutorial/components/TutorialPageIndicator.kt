package presentation.screen.tutorial.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import presentation.screen.tutorial.TutorialScreen
import presentation.theme.PaperHearts
import presentation.theme.PinkPerfume

@Composable
fun TutorialScreen.TutorialPageIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: Int,
) {
    Row(
        modifier = modifier
    ) {
        for (i in 0 until pageCount) {
            if (i > 0) Spacer(modifier = Modifier.width(6.dp))

            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(
                        color = if (i == currentPage) PaperHearts else PinkPerfume
                    )
            )
        }
    }
}