package domain.user

import kotlinx.coroutines.flow.StateFlow
import presentation.theme.StyleSheet

interface UserService {
    val styleSheet: StateFlow<StyleSheet>
    val settings: StateFlow<Settings>

    fun toggleDarkMode()
}