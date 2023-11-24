package domain.platform

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Platform(
    val type: PlatformType = PlatformType.Android,
    val insets: PlatformInsets = PlatformInsets(top = 0.dp, bottom = 0.dp),
)

data class PlatformInsets(
    val top: Dp,
    val bottom: Dp
)

sealed class PlatformType(
    val name: String
) {
    data object Android: PlatformType(
        name = "Android"
    )

    data object IOS: PlatformType(
        name = "iOS"
    )
}