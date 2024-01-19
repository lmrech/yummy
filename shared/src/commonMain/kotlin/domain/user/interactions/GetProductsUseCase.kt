package domain.user.interactions

import domain.user.UserService

class GetProductsUseCase constructor(
    private val userService: UserService
) {
    suspend fun execute() = userService.getProducts()
}