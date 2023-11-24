package presentation.screen.home

import domain.user.Settings

data class HomeUiState(
    val settings: Settings = Settings()
)