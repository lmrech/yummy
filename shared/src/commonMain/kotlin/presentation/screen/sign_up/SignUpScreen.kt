package presentation.screen.sign_up

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import rememberTextStyle

class SignUpScreen : Screen {
    @OptIn(ExperimentalFoundationApi::class)
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
                    .padding(
                        vertical = 34.dp,
                        horizontal = 22.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                    placeholder = stringResource(MR.strings.sign_up_full_name),
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
}