package presentation.screen.tutorial.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import presentation.screen.tutorial.TutorialScreen

@Composable
fun TutorialScreen.TutorialPageLayout(
    pageCount: Int,
    currentPage: Int,
    background: @Composable BoxScope.() -> Unit,
    cardActionButtons: (@Composable RowScope.() -> Unit)? = null,
    cardContent: @Composable ColumnScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box {
            background(this)
        }

        TutorialPageCard(
            modifier = Modifier
                .align(
                    alignment = Alignment.BottomCenter
                ),
            pageCount = pageCount,
            currentPage = currentPage,
            actionButtons = cardActionButtons,
            content = cardContent
        )
    }
}