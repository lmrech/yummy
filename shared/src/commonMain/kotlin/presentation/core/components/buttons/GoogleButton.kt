
package presentation.core.components.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import presentation.core.components.AppButton
import presentation.theme.ShadesOn
import presentation.theme.White

@Composable
fun GoogleButton(
    text: String = stringResource(MR.strings.general_continue_with_google_account),
    onClick: () -> Unit
) {
    AppButton(
        text = text,
        backgroundColor = White,
        elevation = 2.dp,
        icon = MR.images.ic_sign_up_google,
        textAllCaps = false,
        textColor = ShadesOn,
        onClick = onClick
    )
}