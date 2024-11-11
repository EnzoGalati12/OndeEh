package br.com.rm1234.ondeeh.domain.repository

import br.com.rm1234.ondeeh.domain.model.Cep

interface CepRepository {
    suspend fun getCep(cep: String): Cep

    suspend fun getHistoryCeps(): List<Cep>

    suspend fun deleteItemHistory(cep: String)

    suspend fun deleteAllHistory()
}
