package di

import org.koin.dsl.module
import presentation.screen.home.HomeViewModel
import presentation.screen.sign_in.SignInViewModel
import presentation.screen.sign_up.SignUpViewModel
import presentation.screen.splash.SplashViewModel
import presentation.screen.tutorial.TutorialViewModel
import viewModelDefinition

fun viewModelModule() = module {
    viewModelDefinition {
        SplashViewModel()
    }

    viewModelDefinition {
        TutorialViewModel()
    }

    viewModelDefinition {
        SignUpViewModel()
    }

    viewModelDefinition {
        SignInViewModel()
    }

    viewModelDefinition {
        HomeViewModel(
            getSettingsUseCase = get()
        )
    }
}