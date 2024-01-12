package presentation.core.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role

inline fun Modifier.conditional(
    condition: Boolean,
    onSatisfied: Modifier.() -> Modifier
): Modifier = if (condition) {
    then(onSatisfied(Modifier))
} else {
    then(this)
}

@Composable
inline fun Modifier.clickableContent(
    noinline onClick: () -> Unit,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    return this
        .graphicsLayer {
            alpha = if (isPressed) 0.5f else 1f
        }
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick,
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role
        )
}