package presentation.screen.tutorial

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import presentation.core.AppScreen
import presentation.core.AppStatusBar
import presentation.screen.tutorial.components.TutorialNextButton
import presentation.screen.tutorial.components.TutorialPage
import presentation.screen.tutorial.components.TutorialSkipButton
import rememberStyleSheet
import rememberTextStyle

class TutorialScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val viewModel: TutorialViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()
        val navigator = LocalNavigator.current
        val pagerState = rememberPagerState(
            pageCount = { 3 }
        )
        val scope = rememberCoroutineScope()

        AppScreen(
            statusBar = AppStatusBar.Hidden
        ) {
            HorizontalPager(
                state = pagerState
            ) {
                when (pagerState.currentPage) {
                    0 -> TutorialPage1(
                        pageCount = pagerState.currentPage,
                        onSkipClicked = {
                            scope.launch {
                                viewModel.onSkip(
                                    pagerState = pagerState
                                )
                            }
                        },
                        onNextClicked = {
                            scope.launch {
                                viewModel.onNext(
                                    pagerState = pagerState
                                )
                            }
                        }
                    )

                    1 -> TutorialPage2(
                        pageCount = pagerState.currentPage,
                        onSkipClicked = {
                            scope.launch {
                                viewModel.onSkip(
                                    pagerState = pagerState
                                )
                            }
                        },
                        onNextClicked = {
                            scope.launch {
                                viewModel.onNext(
                                    pagerState = pagerState
                                )
                            }
                        }
                    )
                }
            }
        }
    }

    @Composable
    private fun TutorialPage1(
        pageCount: Int,
        onSkipClicked: () -> Unit,
        onNextClicked: () -> Unit
    ) {
        val styleSheet = rememberStyleSheet()
        val textStyle = rememberTextStyle()

        TutorialPage(
            pageCount = pageCount,
            currentPage = 0,
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
            }
        ) {
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
    }

    @Composable
    private fun TutorialPage2(
        pageCount: Int,
        onSkipClicked: () -> Unit,
        onNextClicked: () -> Unit
    ) {

    }
}