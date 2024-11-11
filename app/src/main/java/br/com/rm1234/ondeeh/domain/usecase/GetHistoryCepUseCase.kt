package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.model.Cep
import br.com.rm1234.ondeeh.domain.repository.CepRepository

class GetHistoryCepUseCase(private val repository: CepRepository) {
    suspend operator fun invoke(): List<Cep> {
        return repository.getHistoryCeps()
    }
}
