package presentation.screen.create_account

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import org.koin.compose.koinInject
import presentation.core.AppScreen

class CreateAccountScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: CreateAccountViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()
        val navigator = LocalNavigator.current

        AppScreen {

        }
    }
}