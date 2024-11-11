package br.com.rm1234.ondeeh.domain.usecase

import br.com.rm1234.ondeeh.domain.model.Cep
import br.com.rm1234.ondeeh.domain.repository.CepRepository

class GetCepUseCase(private val repository: CepRepository) {

    suspend operator fun invoke(cep: String): Cep {
        return repository.getCep(cep)
    }

}
