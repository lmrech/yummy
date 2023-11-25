package presentation.screen.tutorial.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import rememberStyleSheet

@Composable
fun TutorialPageCard(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: Int,
    actionButtons: (@Composable RowScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleSheet = rememberStyleSheet()

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp
                    )
                )
                .height(256.dp)
                .background(
                    color = styleSheet.colorScheme.colorBackground
                )
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TutorialPageIndicator(
                    pageCount = pageCount,
                    currentPage = currentPage,
                )
            }

            AnimatedContent(
                modifier = Modifier.weight(1f),
                targetState = content,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    it(this)
                }
            }

            actionButtons?.let { buttons ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    buttons(this)
                }
            }
        }
    }
}