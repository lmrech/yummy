package presentation.core.components.override

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import domain.platform.Platform
import presentation.core.extensions.conditional
import presentation.theme.StyleSheet
import rememberPlatform
import rememberStyleSheet

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    styleSheet: StyleSheet = rememberStyleSheet(),
    platform: Platform = rememberPlatform(),
    statusBarVisibility: StatusBarVisibility = StatusBarVisibility.Visible(),
    navigationBarVisibility: NavigationBarVisibility = NavigationBarVisibility.Visible,
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .conditional(
                condition = navigationBarVisibility is NavigationBarVisibility.Visible
            ) {
                navigationBarsPadding()
            }
            .imePadding()
    ) {
        if (statusBarVisibility is StatusBarVisibility.Visible) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = statusBarVisibility.color
                    )
                    .statusBarsPadding()
            )
        }

        topBar?.invoke()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Column(
                modifier = modifier,
                verticalArrangement = verticalArrangement,
                horizontalAlignment = horizontalAlignment,
                content = content
            )
        }

        bottomBar?.invoke()
    }
}

sealed class StatusBarVisibility {
    data class Visible(val color: Color = Color.Transparent) : StatusBarVisibility()
    data object Hidden : StatusBarVisibility()
}

sealed class NavigationBarVisibility {
    data object Visible : NavigationBarVisibility()
    data object Hidden : NavigationBarVisibility()
}