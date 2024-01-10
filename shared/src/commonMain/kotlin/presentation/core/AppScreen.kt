package presentation.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.platform.Platform
import presentation.core.extensions.conditional
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
    statusBar: AppSystemBar = AppSystemBar.Visible,
    navigationBar: AppSystemBar = AppSystemBar.Visible,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .conditional(
                    condition = statusBar is AppSystemBar.Visible
                ) {
                    statusBarsPadding()
                }
                .conditional(
                    condition = navigationBar is AppSystemBar.Visible
                ) {
                    navigationBarsPadding()
                }
                .imePadding()
        ) {
            Column(
                modifier = modifier,
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment
            ) {
                content(this)
            }
        }
    }
}

sealed class AppSystemBar {
    data object Visible : AppSystemBar()
    data object Hidden : AppSystemBar()
}