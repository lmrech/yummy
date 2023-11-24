package presentation.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.theme.FieryRose
import presentation.theme.White
import rememberTextStyle

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    height: Dp = 56.dp,
    backgroundColor: Color = FieryRose,
    borderRadius: Dp = 8.dp,
    contentAlignment: Alignment = Alignment.Center,
    onClick: (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    height = height
                )
                .clip(
                    shape = RoundedCornerShape(borderRadius)
                )
                .background(
                    color = backgroundColor
                )
                .clickable(
                    enabled = onClick != null,
                    onClick = {
                        onClick?.invoke()
                    }
                ),
            contentAlignment = contentAlignment
        ) {
            content(this)
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
    height: Dp = 56.dp,
    backgroundColor: Color = FieryRose,
    borderRadius: Dp = 8.dp,
    contentAlignment: Alignment = Alignment.Center,
    onClick: (() -> Unit)? = null,
) {
    AppButton(
        modifier = modifier,
        height = height,
        backgroundColor = backgroundColor,
        borderRadius = borderRadius,
        contentAlignment = contentAlignment,
        onClick = onClick
    ) {
        Text(
            text = if (textAllCaps) text.uppercase() else text,
            color = textColor,
            style = textStyle,
            textAlign = TextAlign.Start
        )
    }
}