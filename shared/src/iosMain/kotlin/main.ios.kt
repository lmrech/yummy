
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.ui.unit.Density
import androidx.compose.ui.window.ComposeUIViewController
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.platform.Platform
import domain.platform.PlatformType
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

actual fun getPlatform(
    systemBars: WindowInsets,
    density: Density
): Platform = Platform(
    type = PlatformType.IOS
)

actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = factory(qualifier = qualifier, definition = definition)

fun MainViewController() = ComposeUIViewController { App() }