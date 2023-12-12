package presentation.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import domain.platform.Platform
import presentation.theme.StyleSheet
import rememberPlatform
import rememberStyleSheet

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    styleSheet: StyleSheet = rememberStyleSheet(),
    platform: Platform = rememberPlatform(),
    statusBar: AppStatusBar = AppStatusBar.Visible(
        backgroundColor = styleSheet.colorScheme.colorBackground
    ),
    navigationBar: AppNavigationBar = AppNavigationBar.Visible(
        backgroundColor = styleSheet.colorScheme.colorBackground
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (statusBar is AppStatusBar.Visible) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        height = platform.insets.top
                    )
                    .background(
                        color = statusBar.backgroundColor
                    )
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            Column(
                modifier = modifier,
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment
            ) {
                content(this)
            }
        }

        if (navigationBar is AppNavigationBar.Visible) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        height = platform.insets.bottom
                    )
                    .background(
                        color = navigationBar.backgroundColor
                    )
            )
        }
    }
}

sealed class AppStatusBar {
    data class Visible(val backgroundColor: Color) : AppStatusBar()
    data object Hidden : AppStatusBar()
}

sealed class AppNavigationBar {
    data class Visible(val backgroundColor: Color) : AppNavigationBar()
    data object Hidden : AppNavigationBar()
}