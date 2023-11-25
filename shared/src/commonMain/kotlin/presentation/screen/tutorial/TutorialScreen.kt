package presentation.screen.tutorial

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import presentation.core.AppScreen
import presentation.core.AppStatusBar
import presentation.screen.create_account.CreateAccountScreen
import presentation.screen.tutorial.components.TutorialBackgroundGradient
import presentation.screen.tutorial.components.TutorialPage
import presentation.screen.tutorial.components.TutorialPageLayout

class TutorialScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val viewModel: TutorialViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()
        val navigator = LocalNavigator.current
        val scope = rememberCoroutineScope()
        val pagerState = rememberPagerState(
            pageCount = { TutorialPage.PageIndex.entries.size }
        )

        val pages: List<TutorialPage> = remember {
            listOf(
                TutorialPage.Page1(
                    onNextClicked = {
                        scope.launch {
                            viewModel.onNext(pagerState = pagerState)
                        }
                    },
                    onSkipClicked = {
                        scope.launch {
                            viewModel.onSkip(pagerState = pagerState)
                        }
                    }
                ),
                TutorialPage.Page2(
                    onNextClicked = {
                        scope.launch {
                            viewModel.onNext(pagerState = pagerState)
                        }
                    },
                    onSkipClicked = {
                        scope.launch {
                            viewModel.onSkip(pagerState = pagerState)
                        }
                    }
                ),
                TutorialPage.Page3(
                    onLoginClicked = {
                        // TODO().
                    },
                    onCreateAccountClicked = {
                        navigator?.replaceAll(CreateAccountScreen())
                    }
                )
            )
        }

        AppScreen(
            statusBar = AppStatusBar.Hidden
        ) {
            TutorialPageLayout(
                pageCount = pagerState.pageCount,
                currentPage = pagerState.currentPage,
                background = {
                    HorizontalPager(
                        state = pagerState,
                        verticalAlignment = Alignment.Top,
                    ) {
                        Box {
                            pages[it].background()
                            TutorialBackgroundGradient()
                            pages[it].overlay?.invoke()
                        }
                    }
                },
                cardActionButtons = pages[pagerState.currentPage].cardActionButtons,
                cardContent = pages[pagerState.currentPage].cardContent
            )
        }
    }
}