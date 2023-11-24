package presentation.screen.tutorial.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import presentation.theme.Black
import rememberTextStyle

@Composable
fun TutorialSkipButton(
    onClick: () -> Unit
) {
    val textStyle = rememberTextStyle()

    Row(
        modifier = Modifier
            .clickable(
                onClick = onClick
            )
    ) {
        Text(
            text = stringResource(MR.strings.general_skip),
            fontSize = 16.sp,
            color = Black,
            style = textStyle.copy(
                fontWeight = FontWeight.SemiBold,
                lineHeight = 21.sp,
                textDecoration = TextDecoration.Underline
            ),
            textAlign = TextAlign.Start
        )
    }
}