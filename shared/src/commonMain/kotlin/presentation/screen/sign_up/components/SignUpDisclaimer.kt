package presentation.screen.sign_up.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import presentation.screen.sign_up.SignUpScreen
import presentation.theme.PaperHearts
import presentation.theme.Zambezi
import rememberTextStyle

@Composable
fun SignUpDisclaimer(
    onTermsOfServiceClicked: (String) -> Unit,
    onPrivacyPolicyClicked: (String) -> Unit,
    textStyle: TextStyle = rememberTextStyle()
) {
    val clickableTextStyle = SpanStyle(
        textDecoration = TextDecoration.Underline,
        color = PaperHearts
    )

    val annotatedString = buildAnnotatedString {
        append("${stringResource(MR.strings.sign_up_by_signing_up_you_agree_with_our)} ")

        pushStringAnnotation(
            tag = SignUpScreen.ANNOTATION_TERMS_OF_SERVICE,
            annotation = "https://google.com/terms"
        )

        withStyle(
            style = clickableTextStyle
        ) {
            append(stringResource(MR.strings.sign_up_terms_of_service))
        }

        pop()

        append(" ${stringResource(MR.strings.sign_up_and_the)} ")

        pushStringAnnotation(
            tag = SignUpScreen.ANNOTATION_PRIVACY_POLICY,
            annotation = "https://google.com/policy"
        )

        withStyle(
            style = clickableTextStyle
        ) {
            append(stringResource(MR.strings.sign_up_privacy_policy))
        }

        pop()

        append(".")
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = SignUpScreen.ANNOTATION_PRIVACY_POLICY, start = offset, end = offset).firstOrNull()?.let {
                onTermsOfServiceClicked(it.item)
            }

            annotatedString.getStringAnnotations(tag = SignUpScreen.ANNOTATION_TERMS_OF_SERVICE, start = offset, end = offset).firstOrNull()?.let {
                onPrivacyPolicyClicked(it.item)
            }
        },
        style = textStyle.copy(
            fontWeight = FontWeight.W400,
            fontSize = 13.sp,
            lineHeight = 17.sp,
            color = Zambezi
        )
    )
}