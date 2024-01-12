
package presentation.core.components.buttons

import androidx.compose.runtime.Composable
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import presentation.core.components.AppButton
import presentation.theme.Black

@Composable
fun AppleButton(
    text: String = stringResource(MR.strings.general_continue_with_apple_account),
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