package presentation.screen.sign_up

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import org.koin.compose.koinInject
import presentation.core.components.AppleButton
import presentation.core.components.FacebookButton
import presentation.core.components.GoogleButton
import presentation.core.components.override.AppButton
import presentation.core.components.override.AppScaffold
import presentation.core.components.override.AppTextField
import presentation.core.components.override.AppTopBar
import presentation.core.components.override.StatusBarVisibility
import presentation.core.extensions.alphabetic
import presentation.screen.sign_up.components.SignUpSeparator
import presentation.theme.PaperHearts
import presentation.theme.White
import presentation.theme.Zambezi
import rememberTextStyle

class SignUpScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: SignUpViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()
        val navigator = LocalNavigator.current
        val textStyle = rememberTextStyle()

        AppScaffold(
            modifier = Modifier
                .background(
                    color = PaperHearts
                )
                .verticalScroll(
                    state = rememberScrollState()
                ),
            statusBarVisibility = StatusBarVisibility.Visible(
                color = PaperHearts
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            topBar = {
                AppTopBar(
                    backgroundColor = PaperHearts,
                    onBackPressed = {
                        navigator?.pop()
                    }
                )
            }
        ) {
            Text(
                text = stringResource(MR.strings.sign_up_title),
                color = White,
                style = textStyle.copy(
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                    lineHeight = 32.sp
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 40.dp,
                            topEnd = 40.dp
                        )
                    )
                    .background(
                        color = White
                    )
                    .padding(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp))

                AppTextField(
                    value = uiState.fullNameInput,
                    onValueChange = {
                        viewModel.setFullNameInput(
                            value = it.alphabetic()
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        autoCorrect = false
                    ),
                    placeholder = stringResource(MR.strings.sign_up_your_name),
                )

                Spacer(modifier = Modifier.height(15.dp))

                AppTextField(
                    value = uiState.emailInput,
                    onValueChange = {
                        viewModel.setEmailInput(
                            value = it
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false
                    ),
                    placeholder = stringResource(MR.strings.sign_up_email),
                )

                Spacer(modifier = Modifier.height(15.dp))

                AppTextField(
                    value = uiState.passwordInput,
                    onValueChange = {
                        viewModel.setPasswordInput(
                            value = it
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false
                    ),
                    placeholder = stringResource(MR.strings.sign_up_password),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(15.dp))

                AppTextField(
                    value = uiState.confirmPasswordInput,
                    onValueChange = {
                        viewModel.setConfirmPasswordInput(
                            value = it
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        autoCorrect = false
                    ),
                    placeholder = stringResource(MR.strings.sign_up_confirm_password),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(20.dp))

                AppButton(
                    text = stringResource(MR.strings.sign_up_create_account),
                    enabled = uiState.isValid(),
                    backgroundColor = PaperHearts,
                    textAllCaps = false
                ) {
                    // TODO().
                }

                Spacer(modifier = Modifier.height(20.dp))

                SignUpDisclaimer(
                    onTermsOfServiceClicked = {
                        // TODO().
                    },
                    onPrivacyPolicyClicked = {
                        // TODO().
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                SignUpSeparator(
                    text = stringResource(MR.strings.general_or)
                )

                Spacer(modifier = Modifier.height(20.dp))

                FacebookButton {
                    // TODO().
                }

                Spacer(modifier = Modifier.height(20.dp))

                GoogleButton {
                    // TODO().
                }

                Spacer(modifier = Modifier.height(20.dp))

                AppleButton {
                    // TODO().
                }
            }
        }
    }

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
                tag = ANNOTATION_TERMS_OF_SERVICE,
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
                tag = ANNOTATION_PRIVACY_POLICY,
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
                annotatedString.getStringAnnotations(tag = ANNOTATION_PRIVACY_POLICY, start = offset, end = offset).firstOrNull()?.let {
                    onTermsOfServiceClicked(it.item)
                }

                annotatedString.getStringAnnotations(tag = ANNOTATION_TERMS_OF_SERVICE, start = offset, end = offset).firstOrNull()?.let {
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

    companion object {
        const val ANNOTATION_TERMS_OF_SERVICE = "ANNOTATION_TERMS_OF_SERVICE"
        const val ANNOTATION_PRIVACY_POLICY = "ANNOTATION_PRIVACY_POLICY"
    }
}