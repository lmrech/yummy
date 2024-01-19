package domain.core

sealed class RepositoryResponse<T> {
    data class Success<T>(val result: T) : RepositoryResponse<T>()
    data class Error<T>(val throwable: Throwable) : RepositoryResponse<T>()
    class Loading<T>: RepositoryResponse<T>()
}