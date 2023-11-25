package presentation.screen.create_account

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CreateAccountViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<CreateAccountUiState> = MutableStateFlow(CreateAccountUiState)
    val uiState: StateFlow<CreateAccountUiState> = _uiState.asStateFlow()
}