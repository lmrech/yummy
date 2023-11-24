
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.platform.Platform
import domain.platform.PlatformInsets
import domain.platform.PlatformType
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.copy
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import platform.UIKit.UIApplication

@OptIn(ExperimentalForeignApi::class)
actual fun getPlatform(
    systemBars: WindowInsets,
    density: Density
): Platform {
    UIApplication.sharedApplication.keyWindow?.safeAreaInsets?.copy {
        return Platform(
            type = PlatformType.IOS,
            insets = PlatformInsets(
                top = this.top.dp,
                bottom = this.bottom.dp
            )
        )
    }

    return Platform(
        type = PlatformType.IOS,
        insets = PlatformInsets(
            top = 0.dp,
            bottom = 0.dp
        )
    )
}

actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = factory(qualifier = qualifier, definition = definition)

fun MainViewController() = ComposeUIViewController { App() }