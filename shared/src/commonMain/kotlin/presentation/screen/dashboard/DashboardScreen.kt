package presentation.screen.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.painterResource
import presentation.core.components.AppBottomNavigationButtonItem
import presentation.core.components.AppBottomNavigationItem
import presentation.core.components.AppBottomNavigationTabItem
import presentation.core.components.AppScaffold
import presentation.core.components.NavigationBarVisibility
import presentation.core.components.StatusBarVisibility
import presentation.screen.home.HomeScreen
import presentation.screen.profile.ProfileScreen
import presentation.theme.Black
import presentation.theme.PaperHearts
import presentation.theme.Transparent
import presentation.theme.White

class DashboardScreen : Screen {
    @Composable
    override fun Content() {
        val homeTab = AppBottomNavigationItem.Tab(
            index = 0,
            stringResource = MR.strings.dashboard_bottom_navigation_tab_home,
            imageResource = MR.images.ic_bottom_navigation_tab_profile,
            content = HomeScreen().Content()
        )

        val restaurantsTab = AppBottomNavigationItem.Tab(
            index = 1,
            stringResource = MR.strings.dashboard_bottom_navigation_tab_restaurants,
            imageResource = MR.images.ic_bottom_navigation_tab_restaurants,
            content = ProfileScreen().Content()
        )

        val reviewTab = AppBottomNavigationItem.Button(
            index = 2,
            stringResource = MR.strings.dashboard_bottom_navigation_tab_review
        )

        val friendsTab = AppBottomNavigationItem.Tab(
            index = 3,
            stringResource = MR.strings.dashboard_bottom_navigation_tab_friends,
            imageResource = MR.images.ic_bottom_navigation_tab_friends,
            content = ProfileScreen().Content()
        )

        val profileTab = AppBottomNavigationItem.Tab(
            index = 4,
            stringResource = MR.strings.dashboard_bottom_navigation_tab_profile,
            imageResource = MR.images.ic_bottom_navigation_tab_profile,
            content = ProfileScreen().Content()
        )

        val tabs by remember {
            mutableStateOf(
                listOf(
                    homeTab,
                    restaurantsTab,
                    reviewTab,
                    friendsTab,
                    profileTab
                )
            )
        }

        TabNavigator(
            tab = homeTab
        ) {
            AppScaffold(
                statusBarVisibility = StatusBarVisibility.Hidden,
                navigationBarVisibility = NavigationBarVisibility.Visible,
                bottomBar = {
                    Box {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Transparent,
                                            Black.copy(
                                                alpha = 0.05f
                                            ),
                                        )
                                    )
                                )
                                .offset(
                                    y = (-2).dp
                                )
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            tabs.forEach {
                                when (it) {
                                    is AppBottomNavigationItem.Tab -> {
                                        AppBottomNavigationTabItem(
                                            item = it
                                        )
                                    }

                                    is AppBottomNavigationItem.Button -> {
                                        AppBottomNavigationButtonItem(
                                            item = it,
                                            onClick = { index ->
                                                // TODO().
                                            }
                                        )
                                    }
                                }
                            }
                        }

                        Box(
                            modifier = Modifier
                                .align(
                                    alignment = Alignment.TopCenter
                                )
                                .offset(
                                    y = -(18).dp
                                )
                                .clip(
                                    shape = CircleShape
                                )
                                .background(
                                    color = PaperHearts
                                )
                                .size(36.dp)
                                .clickable {
                                    // TODO().
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(MR.images.ic_bottom_navigation_button_add_review),
                                contentDescription = null,
                                tint = White
                            )
                        }
                    }
                },
                content = {
                    CurrentTab()
                }
            )
        }
    }
}