package br.com.rm1234.ondeeh.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rm1234.ondeeh.domain.model.Cep
import br.com.rm1234.ondeeh.domain.usecase.GetCepUseCase
import kotlinx.coroutines.launch

class DetalheViewModel(private val getCepUseCase: GetCepUseCase) : ViewModel() {

    private val _cepData = MutableLiveData<Cep>()
    val cepData: LiveData<Cep> get() = _cepData

    fun fetchCep(cep: String) {
        viewModelScope.launch {
            val result = getCepUseCase(cep)
            _cepData.value = result
        }
    }
}
