package presentation.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import presentation.theme.AmericanSilver
import presentation.theme.DeadPixel
import presentation.theme.Gray
import presentation.theme.Transparent
import rememberTextStyle

@Composable
fun AppTextInput(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    minHeight: Dp = 40.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val textStyle = rememberTextStyle()

    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            color = DeadPixel,
            style = textStyle.copy(
                fontWeight = FontWeight.W700,
                fontSize = 15.sp,
                lineHeight = 20.sp
            ),
            textAlign = TextAlign.Start
        )

        Card(
            shape = RoundedCornerShape(
                size = 3.dp
            ),
            backgroundColor = Transparent,
            border = BorderStroke(
                width = 1.dp,
                color = Gray
            ),
            elevation = 0.dp
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .defaultMinSize(
                        minHeight = minHeight
                    ),
                contentAlignment = Alignment.Center
            ) {
                BasicTextField(
                    modifier = Modifier
                        .padding(
                            vertical = 9.dp,
                            horizontal = 10.dp
                        )
                        .defaultMinSize(
                            minWidth = this.constraints.maxWidth.dp
                        ),
                    value = value,
                    onValueChange = onValueChange,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    singleLine = singleLine,
                    maxLines = maxLines,
                    minLines = minLines,
                    visualTransformation = visualTransformation,
                    textStyle = textStyle.copy(
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        lineHeight = 21.sp
                    ),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = AmericanSilver,
                                style = textStyle.copy(
                                    fontWeight = FontWeight.W400,
                                    fontSize = 16.sp,
                                    lineHeight = 21.sp
                                ),
                                textAlign = TextAlign.Start
                            )
                        }

                        innerTextField.invoke()
                    }
                )
            }
        }
    }
}