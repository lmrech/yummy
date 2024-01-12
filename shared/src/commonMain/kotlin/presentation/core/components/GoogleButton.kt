
package presentation.core.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.icerockdev.library.MR
import presentation.theme.ShadesOn
import presentation.theme.White

@Composable
fun GoogleButton(
    text: String,
    onClick: () -> Unit
) {
    presentation.core.components.override.AppButton(
        text = text,
        backgroundColor = White,
        elevation = 2.dp,
        icon = MR.images.ic_sign_up_google,
        textAllCaps = false,
        textColor = ShadesOn,
        onClick = onClick
    )
}