package presentation.screen.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import org.koin.compose.koinInject
import presentation.core.AppNavigationBar
import presentation.core.AppScreen
import presentation.core.AppStatusBar
import presentation.theme.SchaussPink

class SplashScreen(
    val content: @Composable () -> Unit
) : Screen {
    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()

        Box {
            content()

            AnimatedVisibility(
                visible = uiState.isVisible,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                AppScreen(
                    statusBar = AppStatusBar.Hidden,
                    navigationBar = AppNavigationBar.Hidden
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = SchaussPink
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(MR.images.ic_splash_logo),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}