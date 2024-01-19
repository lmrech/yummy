package di

import data.user.UserApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.URLProtocol
import org.koin.dsl.module

fun apiModule() = module {
    val ktorClient = HttpClient {
        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "ipapi.co"
            }
        }
    }

    single {
        UserApi(
            ktorClient = ktorClient
        )
    }
}