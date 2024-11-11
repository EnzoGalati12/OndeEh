package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.repository.CepRepository

class DeleteItemHistoryUseCase(private val repository: CepRepository) {
    suspend operator fun invoke(cep: String) {
        return repository.deleteItemHistory(cep)
    }
}
