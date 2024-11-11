package br.com.rm1234.ondeeh.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rm1234.ondeeh.domain.model.Cep
import br.com.rm1234.ondeeh.domain.usecase.DeleteAllHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.DeleteItemHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.GetHistoryCepUseCase
import kotlinx.coroutines.launch

class CepHistoryViewModel(
    private val getHistoryCepUseCase: GetHistoryCepUseCase,
    private val deleteItemHistoryUseCase: DeleteItemHistoryUseCase,
    private val deleteAllHistoryUseCase: DeleteAllHistoryUseCase
) : ViewModel() {

    private val _cepAllHistory = MutableLiveData<List<Cep>>()
    val cepAllHistory: LiveData<List<Cep>> get() = _cepAllHistory

    fun getHistory() {
        viewModelScope.launch {
            val result = getHistoryCepUseCase()
            _cepAllHistory.value = result
        }
    }

    fun delete(cep: String) {
        viewModelScope.launch {
            deleteItemHistoryUseCase(cep)
            getHistory()
        }
    }


    fun deleteAll() {
        viewModelScope.launch {
            deleteAllHistoryUseCase()

        }
    }

}
