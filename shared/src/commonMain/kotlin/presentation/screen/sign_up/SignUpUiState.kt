package presentation.screen.sign_up

import presentation.core.extensions.emptyString
import presentation.core.extensions.minLength
import presentation.core.extensions.validEmail

data class SignUpUiState(
    val fullNameInput: String = emptyString(),
    val emailInput: String = emptyString(),
    val passwordInput: String = emptyString(),
    val confirmPasswordInput: String = emptyString()
) {
    private fun isValidName(): Boolean {
        return fullNameInput.isNotEmpty()
    }

    private fun isValidEmail(): Boolean {
        return emailInput.validEmail()
    }

    private fun isValidPassword(): Boolean {
        return passwordInput.minLength(6)
    }

    private fun isValidPasswordConfirmation(): Boolean {
        return confirmPasswordInput == passwordInput
    }
    fun isValid(): Boolean {
        return isValidName() && isValidEmail() && isValidPassword() && isValidPasswordConfirmation()
    }
}