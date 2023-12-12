package presentation.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.compose.painterResource
import presentation.theme.FieryRose
import presentation.theme.Transparent
import presentation.theme.White
import rememberTextStyle

@Composable
fun AppButton(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    enabled: Boolean = true,
    elevation: Dp = 0.dp,
    minHeight: Dp = 56.dp,
    backgroundColor: Color = FieryRose,
    borderRadius: Dp = 8.dp,
    contentAlignment: Alignment = Alignment.Center,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        Card(
            shape = RoundedCornerShape(borderRadius),
            elevation = elevation,
            backgroundColor = Transparent
        ) {
            Box(
                modifier = Modifier
                    .defaultMinSize(
                        minHeight = minHeight,
                        minWidth = this.constraints.maxWidth.dp,
                    )
                    .background(
                        color = backgroundColor.copy(
                            alpha = if (enabled) 1f else 0.5f
                        )
                    )
                    .clickable(
                        enabled = enabled,
                        onClick = onClick
                    ),
                contentAlignment = contentAlignment
            ) {
                content(this)
            }
        }
    }
}

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = White,
    textStyle: TextStyle = rememberTextStyle().copy(
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp
    ),
    textAllCaps: Boolean = true,
    icon: ImageResource? = null,
    enabled: Boolean = true,
    elevation: Dp = 0.dp,
    minHeight: Dp = 56.dp,
    backgroundColor: Color = FieryRose,
    borderRadius: Dp = 8.dp,
    contentAlignment: Alignment = Alignment.Center,
    onClick: () -> Unit,
) {
    AppButton(
        modifier = modifier,
        enabled = enabled,
        elevation = elevation,
        minHeight = minHeight,
        backgroundColor = backgroundColor,
        borderRadius = borderRadius,
        contentAlignment = contentAlignment,
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Image(
                    painter = painterResource(it),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.width(11.dp))

            Text(
                text = if (textAllCaps) text.uppercase() else text,
                color = textColor,
                style = textStyle,
                textAlign = TextAlign.Start
            )
        }
    }
}