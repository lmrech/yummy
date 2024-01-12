
package presentation.core.components

import androidx.compose.runtime.Composable
import com.icerockdev.library.MR
import presentation.core.components.override.AppButton
import presentation.theme.Black

@Composable
fun AppleButton(
    text: String,
    onClick: () -> Unit
) {
    AppButton(
        text = text,
        backgroundColor = Black,
        icon = MR.images.ic_sign_up_apple,
        textAllCaps = false,
        onClick = onClick
    )
}