package presentation.screen.dashboard

import domain.user.Settings

data class DashboardUiState(
    val settings: Settings = Settings()
)