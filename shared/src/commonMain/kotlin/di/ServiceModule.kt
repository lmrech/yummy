package di

import data.user.UserRepository
import domain.user.UserService
import org.koin.dsl.module

fun serviceModule() = module {
    val userService: UserService = UserRepository()

    single { userService }
}