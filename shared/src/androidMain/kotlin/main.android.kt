
import android.content.res.Resources
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.platform.Platform
import domain.platform.PlatformInsets
import domain.platform.PlatformType
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

actual fun getPlatform(
    systemBars: WindowInsets,
    density: Density
): Platform {
    val resources = Resources.getSystem()
    val displayMetrics = resources.displayMetrics

    val top = systemBars.getTop(density = density)
    val bottom = systemBars.getBottom(density = density)

    return Platform(
        type = PlatformType.Android,
        insets = PlatformInsets(
            top = (top / displayMetrics.density).dp,
            bottom = (bottom / displayMetrics.density).dp
        )
    )
}

actual inline fun <reified T : ViewModel> Module.viewModelDefinition(
    qualifier: Qualifier?,
    noinline definition: Definition<T>,
): KoinDefinition<T> = viewModel(qualifier = qualifier, definition = definition)

@Composable fun MainView() = App()
