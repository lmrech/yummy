package presentation.core.components

import androidx.compose.foundation.layout.Column
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
import cafe.adriel.voyager.navigator.tab.Tab
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

@Composable
fun RowScope.AppTabNavigationItem(
    tab: Tab,
    textStyle: TextStyle = rememberTextStyle()
) {
    val tabNavigator: TabNavigator = LocalTabNavigator.current
    val isSelected = tabNavigator.current == tab

    Column(
        modifier = Modifier
            .clickableAlpha(
                onClick = { tabNavigator.current = tab }
            )
            .weight(1f)
            .padding(9.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        tab.options.icon?.let { icon ->
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
            text = tab.options.title,
            color = if (isSelected) PaperHearts else Palladium,
            style = textStyle.copy(
                fontWeight = if (isSelected) FontWeight.W800 else FontWeight.W600,
                fontSize = 12.sp,
                lineHeight = 13.sp
            ),
            maxLines = if (tab.options.icon != null) 1 else 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

data class AppTab(
    val index: Int,
    val stringResource: StringResource,
    val imageResource: ImageResource? = null,
    val content: Unit
) : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(stringResource)
            val icon: Painter? =
                if (imageResource != null) painterResource(imageResource) else null

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
