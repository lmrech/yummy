package presentation.screen.tutorial

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TutorialViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<TutorialUiState> = MutableStateFlow(TutorialUiState)
    val uiState: StateFlow<TutorialUiState> = _uiState.asStateFlow()

    @OptIn(ExperimentalFoundationApi::class)
    suspend fun onNext(pagerState: PagerState) {
        pagerState.animateScrollToPage(
            page = pagerState.currentPage + 1
        )
    }

    @OptIn(ExperimentalFoundationApi::class)
    suspend fun onSkip(pagerState: PagerState) {
        pagerState.animateScrollToPage(
            page = pagerState.pageCount - 1
        )
    }
}