package presentation.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.koinInject
import presentation.core.components.AppButton
import presentation.core.components.AppScaffold
import presentation.core.components.StatusBarVisibility
import presentation.theme.PaperHearts

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: HomeViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()

        AppScaffold(
            modifier = Modifier
                .padding(22.dp),
            statusBarVisibility = StatusBarVisibility.Visible(
                color = PaperHearts
            )
        ) {
            AppButton(
                text = uiState.status
            ) {
                viewModel.getProducts()
            }
        }
    }
}