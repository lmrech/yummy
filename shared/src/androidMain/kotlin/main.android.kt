import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.platform.Platform
import domain.platform.PlatformType
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

actual fun getPlatform(
    systemBars: WindowInsets,
    density: Density
): Platform = Platform(
    type = PlatformType.Android,
)

actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = viewModel(qualifier = qualifier, definition = definition)

@Composable
fun MainView() = App()
