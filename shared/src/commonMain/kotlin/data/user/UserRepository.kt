package data.user

import domain.user.Settings
import domain.user.UserService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import presentation.theme.StyleSheet

class UserRepository: UserService {

    private val _settings: MutableStateFlow<Settings> = MutableStateFlow(Settings())
    override val settings: StateFlow<Settings> = _settings.asStateFlow()

    private val _styleSheet: MutableStateFlow<StyleSheet> = MutableStateFlow(StyleSheet())
    override val styleSheet: StateFlow<StyleSheet> = _styleSheet.asStateFlow()

    override fun toggleDarkMode() {
        _settings.tryEmit(
            settings.value.copy(
                isDarkMode = !settings.value.isDarkMode
            )
        )
    }
}