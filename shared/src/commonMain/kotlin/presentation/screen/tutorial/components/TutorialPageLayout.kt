package presentation.screen.tutorial.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import presentation.screen.tutorial.TutorialScreen
import presentation.theme.PinkPerfume
import presentation.theme.Transparent

@Composable
fun TutorialScreen.TutorialPageLayout(
    pageCount: Int,
    currentPage: Int,
    background: @Composable BoxScope.() -> Unit,
    actionButtons: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box {
            background(this)
        }

        Box(
            modifier = Modifier
                .align(
                    alignment = Alignment.TopCenter
                )
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

        TutorialPageCard(
            modifier = Modifier
                .align(
                    alignment = Alignment.BottomCenter
                ),
            pageCount = pageCount,
            currentPage = currentPage,
            actionButtons = actionButtons,
            content = content
        )
    }
}