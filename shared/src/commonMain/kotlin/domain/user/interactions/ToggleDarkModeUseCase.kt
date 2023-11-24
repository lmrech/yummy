package domain.user.interactions

import domain.user.UserService

class ToggleDarkModeUseCase constructor(
    private val userService: UserService
) {
    fun execute() = userService.toggleDarkMode()
}