package presentation.screen.sign_up

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import org.koin.compose.koinInject
import presentation.core.AppScreen
import presentation.core.components.AppButton
import presentation.core.components.AppTextField
import presentation.core.components.AppleButton
import presentation.core.components.FacebookButton
import presentation.core.components.GoogleButton
import presentation.core.extensions.alphabetic
import presentation.screen.sign_up.components.SignUpSeparator
import presentation.theme.Black
import presentation.theme.PaperHearts
import rememberTextStyle

class SignUpScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: SignUpViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()
        val navigator = LocalNavigator.current
        val textStyle = rememberTextStyle()

        AppScreen(
            modifier = Modifier
                .verticalScroll(
                    state = rememberScrollState()
                )
                .padding(
                    vertical = 26.dp,
                    horizontal = 22.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(MR.strings.sign_up_title),
                color = Black,
                style = textStyle.copy(
                    fontWeight = FontWeight.W600,
                    fontSize = 22.sp,
                    lineHeight = 30.sp
                ),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(26.dp))

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
                label = stringResource(MR.strings.sign_up_full_name),
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
                label = stringResource(MR.strings.sign_up_email),
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
                label = stringResource(MR.strings.sign_up_password),
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
                label = stringResource(MR.strings.sign_up_confirm_password),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(32.dp))

            AppButton(
                text = stringResource(MR.strings.sign_up_create_account),
                enabled = uiState.isValid(),
                backgroundColor = PaperHearts,
            ) {
                // TODO().
            }

            Spacer(modifier = Modifier.height(32.dp))

            SignUpSeparator(
                text = stringResource(MR.strings.general_or)
            )

            Spacer(modifier = Modifier.height(32.dp))

            FacebookButton(
                text = stringResource(MR.strings.sign_up_create_facebook_account)
            ) {
                // TODO().
            }

            Spacer(modifier = Modifier.height(21.dp))

            GoogleButton(
                text = stringResource(MR.strings.sign_up_create_google_account)
            ) {
                // TODO().
            }

            Spacer(modifier = Modifier.height(21.dp))

            AppleButton(
                text = stringResource(MR.strings.sign_up_create_apple_account)
            ) {
                // TODO().
            }
        }
    }
}