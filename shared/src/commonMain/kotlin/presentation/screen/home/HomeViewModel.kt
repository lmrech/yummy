package presentation.screen.home

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.user.Settings
import domain.user.interactions.GetSettingsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val getSettingsUseCase: GetSettingsUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getSettings().collectLatest { settings: Settings ->
                _uiState.tryEmit(
                    uiState.value.copy(
                        settings = settings
                    )
                )
            }
        }
    }

    private fun getSettings() = getSettingsUseCase.execute()
}