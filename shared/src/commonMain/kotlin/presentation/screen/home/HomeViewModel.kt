package presentation.screen.home

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.core.RepositoryResponse
import domain.user.interactions.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun getProducts() {
        viewModelScope.launch {
            getProductsUseCase.execute().collect { response ->
                when (response) {
                    is RepositoryResponse.Success -> _uiState.update {
                        it.copy(
                            status = "success: ${response.result}"
                        )
                    }

                    is RepositoryResponse.Error -> _uiState.update {
                        it.copy(
                            status = "error: ${response.throwable.message}"
                        )
                    }

                    is RepositoryResponse.Loading -> _uiState.update {
                        it.copy(
                            status = "loading"
                        )
                    }
                }
            }
        }
    }
}