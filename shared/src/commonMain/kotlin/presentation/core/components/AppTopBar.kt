package presentation.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import presentation.core.extensions.clickableAlpha
import presentation.theme.White
import rememberTextStyle

@Composable
fun AppTopBar(
    backgroundColor: Color = Color.Transparent,
    paddingValues: PaddingValues = PaddingValues(
        vertical = 9.dp,
        horizontal = 22.dp
    ),
    textStyle: TextStyle = rememberTextStyle(),
    textColor: Color = White,
    iconColor: Color = White,
    onBackPressed: () -> Unit
) {
    AppTopBar(
        backgroundColor = backgroundColor,
        paddingValues = paddingValues,
        start = {
            Row(
                modifier = Modifier
                    .clickableAlpha(
                        onClick = onBackPressed
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(MR.images.ic_arrow_back),
                    contentDescription = null,
                    tint = iconColor
                )

                Spacer(modifier = Modifier.width(9.dp))

                Text(
                    text = stringResource(MR.strings.general_back),
                    color = textColor,
                    style = textStyle.copy(
                        fontWeight = FontWeight.W300,
                        fontSize = 18.sp,
                        lineHeight = 24.sp
                    ),
                    textAlign = TextAlign.Start
                )
            }
        }
    )
}

@Composable
fun AppTopBar(
    backgroundColor: Color = Color.Transparent,
    paddingValues: PaddingValues = PaddingValues(
        vertical = 9.dp,
        horizontal = 22.dp
    ),
    start: @Composable (BoxScope.() -> Unit)? = null,
    center: @Composable (BoxScope.() -> Unit)? = null,
    end: @Composable (BoxScope.() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor
            )
            .padding(
                paddingValues = paddingValues
            )
    ) {
        start?.let {
            Box(
                contentAlignment = Alignment.CenterStart,
                content = it
            )
        }

        center?.let {
            Box(
                contentAlignment = Alignment.Center,
                content = it
            )
        }

        end?.let {
            Box(
                contentAlignment = Alignment.CenterEnd,
                content = it
            )
        }
    }
}