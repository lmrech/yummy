package presentation.screen.sign_up.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.theme.HardCoal
import rememberTextStyle

@Composable
fun SignUpSeparator(
    text: String,
    color: Color = HardCoal
) {
    val textStyle = rememberTextStyle()

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier.width(100.dp),
            thickness = 0.5.dp,
            color = color
        )

        Spacer(modifier = Modifier.width(11.dp))

        Text(
            text = text,
            color = color,
            style = textStyle.copy(
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.width(11.dp))

        Divider(
            modifier = Modifier.width(100.dp),
            thickness = 0.5.dp,
            color = color
        )
    }
}