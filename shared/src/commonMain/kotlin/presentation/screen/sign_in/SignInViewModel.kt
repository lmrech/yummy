package presentation.screen.sign_in

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<SignInUiState> = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    fun setEmailInput(value: String) {
        _uiState.tryEmit(
            uiState.value.copy(
                emailInput = value
            )
        )
    }

    fun setPasswordInput(value: String) {
        _uiState.tryEmit(
            uiState.value.copy(
                passwordInput = value
            )
        )
    }
}