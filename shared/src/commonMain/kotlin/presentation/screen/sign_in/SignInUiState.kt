package presentation.screen.sign_in

import presentation.core.extensions.emptyString
import presentation.core.extensions.minLength
import presentation.core.extensions.validEmail

data class SignInUiState(
    val emailInput: String = emptyString(),
    val passwordInput: String = emptyString()
) {
    private fun isValidEmail(): Boolean {
        return emailInput.validEmail()
    }

    private fun isValidPassword(): Boolean {
        return passwordInput.minLength(6)
    }

    fun isValid(): Boolean {
        return isValidEmail() && isValidPassword()
    }
}