package domain.platform

data class Platform(
    val type: PlatformType = PlatformType.Android,
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