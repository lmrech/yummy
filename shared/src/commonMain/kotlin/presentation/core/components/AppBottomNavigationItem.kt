package presentation.core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import presentation.core.extensions.clickableAlpha
import presentation.theme.Palladium
import presentation.theme.PaperHearts
import rememberTextStyle

sealed class AppBottomNavigationItem(
    open val index: Int,
    open val stringResource: StringResource
) {
    data class Tab(
        override val index: Int,
        override val stringResource: StringResource,
        val imageResource: ImageResource,
        val content: Unit
    ) : AppBottomNavigationItem(
        index = index,
        stringResource = stringResource,
    ), cafe.adriel.voyager.navigator.tab.Tab {
        override val options: TabOptions
            @Composable
            get() {
                val title = stringResource(stringResource)
                val icon: Painter = painterResource(imageResource)

                return remember {
                    TabOptions(
                        index = index.toUShort(),
                        title = title,
                        icon = icon
                    )
                }
            }

        @Composable
        override fun Content() = content
    }

    data class Button(
        override val index: Int,
        override val stringResource: StringResource,
    ): AppBottomNavigationItem(
        index = index,
        stringResource = stringResource
    )
}

@Composable
fun RowScope.AppBottomNavigationItem(
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .clickableAlpha(
                onClick = onClick
            )
            .weight(1f)
            .padding(
                vertical = 9.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}


@Composable
fun RowScope.AppBottomNavigationTabItem(
    item: AppBottomNavigationItem.Tab,
    textStyle: TextStyle = rememberTextStyle(),
) {
    val tabNavigator: TabNavigator = LocalTabNavigator.current
    val isSelected = tabNavigator.current == item

    AppBottomNavigationItem(
        onClick = { tabNavigator.current = item }
    ) {
        item.options.icon?.let { icon ->
            Icon(
                modifier = Modifier
                    .size(24.dp),
                painter = icon,
                contentDescription = null,
                tint = if (isSelected) PaperHearts else Palladium
            )

            Spacer(modifier = Modifier.height(4.dp))
        }

        Text(
            text = item.options.title,
            color = if (isSelected) PaperHearts else Palladium,
            style = textStyle.copy(
                fontWeight = if (isSelected) FontWeight.W800 else FontWeight.W600,
                fontSize = 12.sp,
                lineHeight = 13.sp
            ),
            maxLines = if (item.options.icon != null) 1 else 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RowScope.AppBottomNavigationButtonItem(
    item: AppBottomNavigationItem.Button,
    textStyle: TextStyle = rememberTextStyle(),
    onClick: (Int) -> Unit
) {
    AppBottomNavigationItem(
        onClick = { onClick(item.index) }
    ) {
        Text(
            text = stringResource(item.stringResource),
            color = Palladium,
            style = textStyle.copy(
                fontWeight = FontWeight.W600,
                fontSize = 12.sp,
                lineHeight = 13.sp
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}