package presentation.screen.sign_up

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<SignUpUiState> = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun setFullNameInput(value: String) {
        _uiState.tryEmit(
            uiState.value.copy(
                fullNameInput = value
            )
        )
    }

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

    fun setConfirmPasswordInput(value: String) {
        _uiState.tryEmit(
            uiState.value.copy(
                confirmPasswordInput = value
            )
        )
    }
}