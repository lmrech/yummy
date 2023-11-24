package presentation.screen.tutorial.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import rememberStyleSheet
import rememberTextStyle

sealed class TutorialPage(
    val background: @Composable () -> Unit,
    val actionButtons: (@Composable RowScope.() -> Unit)? = null,
    val content: @Composable ColumnScope.() -> Unit,
) {
    data class Page1(
        val pageCount: Int,
        val currentPage: Int,
        val onSkipClicked: () -> Unit,
        val onNextClicked: () -> Unit
    ) : TutorialPage(
        background = {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(MR.images.bg_tutorial_page_1),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        },
        actionButtons = {
            TutorialSkipButton(
                onClick = onSkipClicked
            )

            Spacer(modifier = Modifier.weight(1f))

            TutorialNextButton(
                onClick = onNextClicked
            )
        },
        content = {
            val styleSheet = rememberStyleSheet()
            val textStyle = rememberTextStyle()

            Text(
                text = stringResource(MR.strings.tutorial_page_1_title),
                fontSize = 18.sp,
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp
                ),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = stringResource(MR.strings.tutorial_page_1_description),
                fontSize = 16.sp,
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    lineHeight = 21.sp
                ),
                textAlign = TextAlign.Start
            )
        }
    )

    data class Page2(
        val pageCount: Int,
        val currentPage: Int,
        val onSkipClicked: () -> Unit,
        val onNextClicked: () -> Unit
    ) : TutorialPage(
        background = {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(MR.images.bg_tutorial_page_2),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        },
        actionButtons = {
            TutorialSkipButton(
                onClick = onSkipClicked
            )

            Spacer(modifier = Modifier.weight(1f))

            TutorialNextButton(
                onClick = onNextClicked
            )
        },
        content = {
            val styleSheet = rememberStyleSheet()
            val textStyle = rememberTextStyle()

            Text(
                text = stringResource(MR.strings.tutorial_page_2_title),
                fontSize = 18.sp,
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp
                ),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = stringResource(MR.strings.tutorial_page_2_description),
                fontSize = 16.sp,
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    lineHeight = 21.sp
                ),
                textAlign = TextAlign.Start
            )
        }
    )
}