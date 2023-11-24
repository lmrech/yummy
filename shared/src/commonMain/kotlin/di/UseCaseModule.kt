package di

import domain.user.interactions.GetSettingsUseCase
import domain.user.interactions.ToggleDarkModeUseCase
import org.koin.dsl.module

fun useCaseModule() = module {
    single { GetSettingsUseCase(userService = get()) }
    single { ToggleDarkModeUseCase(userService = get()) }
}