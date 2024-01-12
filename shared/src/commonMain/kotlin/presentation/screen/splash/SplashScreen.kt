package presentation.screen.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import org.koin.compose.koinInject
import presentation.core.components.AppImage
import presentation.core.components.AppScaffold
import presentation.core.components.AppShadow
import presentation.core.components.NavigationBarVisibility
import presentation.core.components.StatusBarVisibility
import presentation.screen.splash.components.SplashLogoBackground
import presentation.theme.PaperHearts
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
                AppScaffold(
                    statusBarVisibility = StatusBarVisibility.Hidden,
                    navigationBarVisibility = NavigationBarVisibility.Hidden
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = SchaussPink
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        SplashLogoBackground()

                        AppImage(
                            painter = painterResource(MR.images.ic_splash_logo_foreground),
                            contentDescription = null,
                            shadow = AppShadow(
                                color = PaperHearts,
                                x = 3.dp,
                                y = 3.dp,
                            )
                        )
                    }
                }
            }
        }
    }
}