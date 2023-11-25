package presentation.screen.tutorial.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import presentation.core.components.AppButton
import presentation.theme.PaperHearts
import presentation.theme.White
import rememberPlatform
import rememberStyleSheet
import rememberTextStyle

sealed class TutorialPage(
    val pageIndex: PageIndex,
    val background: @Composable () -> Unit,
    val overlay: (@Composable () -> Unit)? = null,
    val cardActionButtons: (@Composable RowScope.() -> Unit)? = null,
    val cardContent: @Composable ColumnScope.() -> Unit,
) {
    data class Page1(
        val onSkipClicked: () -> Unit,
        val onNextClicked: () -> Unit
    ) : TutorialPage(
        pageIndex = PageIndex.PAGE_1,
        background = {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(MR.images.bg_tutorial_page_1),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        },
        cardActionButtons = {
            TutorialSkipButton(
                onClick = onSkipClicked
            )

            Spacer(modifier = Modifier.weight(1f))

            TutorialNextButton(
                onClick = onNextClicked
            )
        },
        cardContent = {
            val styleSheet = rememberStyleSheet()
            val textStyle = rememberTextStyle()

            Text(
                text = stringResource(MR.strings.tutorial_page_1_title),
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp
                ),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = stringResource(MR.strings.tutorial_page_1_description),
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    fontSize = 16.sp,
                    lineHeight = 21.sp
                ),
                textAlign = TextAlign.Start
            )
        }
    )

    data class Page2(
        val onSkipClicked: () -> Unit,
        val onNextClicked: () -> Unit
    ) : TutorialPage(
        pageIndex = PageIndex.PAGE_2,
        background = {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(MR.images.bg_tutorial_page_2),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        },
        cardActionButtons = {
            TutorialSkipButton(
                onClick = onSkipClicked
            )

            Spacer(modifier = Modifier.weight(1f))

            TutorialNextButton(
                onClick = onNextClicked
            )
        },
        cardContent = {
            val styleSheet = rememberStyleSheet()
            val textStyle = rememberTextStyle()

            Text(
                text = stringResource(MR.strings.tutorial_page_2_title),
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp
                ),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = stringResource(MR.strings.tutorial_page_2_description),
                color = styleSheet.colorScheme.colorTextPrimary,
                style = textStyle.copy(
                    fontSize = 16.sp,
                    lineHeight = 21.sp
                ),
                textAlign = TextAlign.Start
            )
        }
    )

    data class Page3(
        val onLoginClicked: () -> Unit,
        val onCreateAccountClicked: () -> Unit
    ) : TutorialPage(
        pageIndex = PageIndex.PAGE_3,
        background = {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(MR.images.bg_tutorial_page_3),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        },
        overlay = {
            val platform = rememberPlatform()
            val textStyle = rememberTextStyle()

            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 24.dp
                    )
            ) {
                Spacer(
                    modifier = Modifier
                        .height(
                            height = platform.insets.top
                        )
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            height = 11.dp
                        )
                )

                Text(
                    text = stringResource(MR.strings.tutorial_page_3_title),
                    color = White,
                    style = textStyle.copy(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold,
                        lineHeight = 42.sp
                    ),
                    textAlign = TextAlign.Start
                )
            }
        },
        cardContent = {
            AppButton(
                text = stringResource(MR.strings.tutorial_page_3_button_1),
                onClick = onLoginClicked
            )

            Spacer(modifier = Modifier.height(16.dp))

            AppButton(
                text = stringResource(MR.strings.tutorial_page_3_button_2),
                backgroundColor = PaperHearts,
                onClick = onCreateAccountClicked
            )
        }
    )

    enum class PageIndex {
        PAGE_1,
        PAGE_2,
        PAGE_3
    }
}