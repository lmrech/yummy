package presentation.core.extensions

import androidx.compose.ui.Modifier

inline fun Modifier.conditional(
    condition: Boolean,
    onSatisfied: Modifier.() -> Modifier
): Modifier = if (condition) {
    then(onSatisfied(Modifier))
} else {
    then(this)
}