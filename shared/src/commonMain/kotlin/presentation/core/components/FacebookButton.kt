package presentation.core.components

import androidx.compose.runtime.Composable
import com.icerockdev.library.MR
import presentation.theme.Azul

@Composable
fun FacebookButton(
    text: String,
    onClick: () -> Unit
) {
    presentation.core.components.override.AppButton(
        text = text,
        backgroundColor = Azul,
        icon = MR.images.ic_sign_up_facebook,
        textAllCaps = false,
        onClick = onClick
    )
}