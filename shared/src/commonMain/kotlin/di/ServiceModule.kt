package di

import data.user.UserRepository
import domain.user.UserService
import org.koin.dsl.module

fun serviceModule() = module {
    single {
        val userService: UserService = UserRepository(
            userApi = get()
        )
        userService
    }
}