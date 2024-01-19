package domain.user

import domain.core.RepositoryResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import presentation.theme.StyleSheet

interface UserService {
    val styleSheet: StateFlow<StyleSheet>
    val settings: StateFlow<Settings>

    fun toggleDarkMode()
    suspend fun getProducts(): Flow<RepositoryResponse<String>>
}