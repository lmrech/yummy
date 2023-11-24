package domain.user.interactions

import domain.user.UserService

class GetSettingsUseCase constructor(
    private val userService: UserService
) {
    fun execute() = userService.settings
}