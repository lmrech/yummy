package presentation.screen.tutorial

import androidx.compose.foundation.ExperimentalFoundationApi
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
            pageCount = { 2 }
        )

        val pages: List<TutorialPage> = remember {
            listOf(
                TutorialPage.Page1(
                    pageCount = pagerState.pageCount,
                    currentPage = pagerState.currentPage,
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
                    pageCount = pagerState.pageCount,
                    currentPage = pagerState.currentPage,
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
                        pages.get(it).background()
                    }
                },
                actionButtons = pages.get(pagerState.currentPage).actionButtons,
                content = pages.get(pagerState.currentPage).content
            )
        }
    }
}