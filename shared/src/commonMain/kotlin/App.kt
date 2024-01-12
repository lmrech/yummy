
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Density
import cafe.adriel.voyager.navigator.Navigator
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import di.serviceModule
import di.useCaseModule
import di.viewModelModule
import domain.platform.Platform
import domain.user.UserService
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import presentation.core.components.override.AppTransition
import presentation.screen.splash.SplashScreen
import presentation.screen.tutorial.TutorialScreen
import presentation.theme.StyleSheet

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(
                serviceModule(),
                useCaseModule(),
                viewModelModule()
            )
        }
    ) {
        SplashScreen {
            Navigator(TutorialScreen()) { navigator ->
                AppTransition(navigator) { screen ->
                    screen.Content()
                }
            }
        }.Content()
    }
}

@Composable
fun rememberStyleSheet(): StyleSheet {
    val userService: UserService = koinInject()
    var styleSheet: StyleSheet by remember { mutableStateOf(StyleSheet()) }

    LaunchedEffect(userService.styleSheet) {
        styleSheet = userService.styleSheet.value
    }

    return styleSheet
}

@Composable
fun rememberTextStyle(): TextStyle {
    var textStyle: TextStyle? by remember { mutableStateOf(null) }
    if (textStyle == null) textStyle = rememberStyleSheet().fontFamily.toTextStyle()
    return textStyle ?: TextStyle()
}

@Composable
fun rememberPlatform(): Platform {
    val systemBars = WindowInsets.systemBars
    val density = LocalDensity.current
    var platform: Platform by remember { mutableStateOf(Platform()) }

    LaunchedEffect(systemBars, density) {
        platform = getPlatform(
            systemBars = systemBars,
            density = density
        )
    }

    return platform
}

expect fun getPlatform(
    systemBars: WindowInsets,
    density: Density
): Platform

expect inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>
): KoinDefinition<T>