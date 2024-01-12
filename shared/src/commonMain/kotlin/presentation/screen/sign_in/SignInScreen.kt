package presentation.screen.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource
import org.koin.compose.koinInject
import presentation.core.components.buttons.AppleButton
import presentation.core.components.buttons.FacebookButton
import presentation.core.components.buttons.GoogleButton
import presentation.core.components.AppButton
import presentation.core.components.AppScaffold
import presentation.core.components.AppTextField
import presentation.core.components.AppTopBar
import presentation.core.components.StatusBarVisibility
import presentation.core.extensions.clickableAlpha
import presentation.screen.dashboard.DashboardScreen
import presentation.screen.sign_up.components.SignUpSeparator
import presentation.theme.FieryRose
import presentation.theme.PaperHearts
import presentation.theme.TentaclePink
import presentation.theme.White
import rememberTextStyle

class SignInScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: SignInViewModel = koinInject()
        val uiState by viewModel.uiState.collectAsState()
        val navigator = LocalNavigator.current
        val textStyle = rememberTextStyle()

        AppScaffold(
            modifier = Modifier
                .background(
                    color = FieryRose
                )
                .verticalScroll(
                    state = rememberScrollState()
                ),
            statusBarVisibility = StatusBarVisibility.Visible(
                color = FieryRose
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            topBar = {
                AppTopBar(
                    backgroundColor = FieryRose,
                    onBackPressed = {
                        navigator?.pop()
                    }
                )
            }
        ) {
            Text(
                text = stringResource(MR.strings.sign_in_title),
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
                    .padding(22.dp)
            ) {
                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(122.dp)
                            .background(
                                color = TentaclePink
                            )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

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
                    placeholder = stringResource(MR.strings.sign_in_enter),
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
                    placeholder = stringResource(MR.strings.sign_in_password),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    modifier = Modifier
                        .clickableAlpha(
                            onClick = {
                                // TODO().
                            }
                        ),
                    text = stringResource(MR.strings.sign_in_forgot_password),
                    color = PaperHearts,
                    style = textStyle.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 13.sp,
                        lineHeight = 17.sp
                    ),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(20.dp))

                AppButton(
                    text = stringResource(MR.strings.sign_in_enter),
                    enabled = uiState.isValid(),
                    backgroundColor = PaperHearts,
                    textAllCaps = false
                ) {
                    navigator?.replaceAll(DashboardScreen())
                }

                Spacer(modifier = Modifier.height(20.dp))

                SignUpSeparator(
                    modifier = Modifier
                        .fillMaxWidth(),
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
}