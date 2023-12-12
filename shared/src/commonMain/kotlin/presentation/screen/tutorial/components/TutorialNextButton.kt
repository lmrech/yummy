package presentation.screen.tutorial.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import presentation.theme.FieryRose
import presentation.theme.White
import rememberTextStyle

@Composable
fun TutorialNextButton(
    onClick: () -> Unit
) {
    val textStyle = rememberTextStyle()

    Row(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                color = FieryRose
            )
            .padding(
                vertical = 8.dp,
                horizontal = 11.dp
            )
            .clickable(
                onClick = onClick
            )
    ) {
        Text(
            text = stringResource(MR.strings.general_next),
            color = White,
            style = textStyle.copy(
                fontWeight = FontWeight.W600,
                fontSize = 15.sp,
                lineHeight = 20.sp
            ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(MR.images.ic_tutorial_next),
            contentDescription = null
        )
    }
}