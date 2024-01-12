package presentation.core.components.buttons

import androidx.compose.runtime.Composable
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import presentation.core.components.AppButton
import presentation.theme.Azul

@Composable
fun FacebookButton(
    text: String = stringResource(MR.strings.general_continue_with_facebook_account),
    onClick: () -> Unit
) {
    AppButton(
        text = text,
        backgroundColor = Azul,
        icon = MR.images.ic_sign_up_facebook,
        textAllCaps = false,
        onClick = onClick
    )
}