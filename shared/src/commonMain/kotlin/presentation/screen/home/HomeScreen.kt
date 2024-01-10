package presentation.screen.home

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.koinInject
import presentation.core.AppScreen
import presentation.core.AppSystemBar

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: HomeViewModel = koinInject()

        AppScreen(
            modifier = Modifier
                .verticalScroll(
                    state = rememberScrollState()
                ),
            navigationBar = AppSystemBar.Hidden
        ) {

        }
    }
}