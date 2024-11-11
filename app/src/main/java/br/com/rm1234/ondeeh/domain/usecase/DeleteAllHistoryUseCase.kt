package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.model.Cep
import br.com.rm1234.ondeeh.domain.repository.CepRepository

class DeleteAllHistoryUseCase(private val repository: CepRepository) {
    suspend operator fun invoke() {
        return repository.deleteAllHistory()
    }
}