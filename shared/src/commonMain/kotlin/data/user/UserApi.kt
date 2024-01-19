package data.user

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class UserApi(
    private val ktorClient: HttpClient
) {
    suspend fun getProducts(): Result<String> = runCatching {
        return@runCatching ktorClient.get("8.8.8.8/json").body()
    }
}