package br.com.rm1234.ondeeh.data.repository

import br.com.rm1234.ondeeh.data.local.dao.CepDao
import br.com.rm1234.ondeeh.data.remote.api.ViaCepService
import br.com.rm1234.ondeeh.domain.model.Cep
import br.com.rm1234.ondeeh.domain.repository.CepRepository

class CepRepositoryImpl(
    private val cepDao: CepDao,
    private val viaCepService: ViaCepService
) : CepRepository {

    override suspend fun getCep(cep: String): Cep {
        val cachedCep = cepDao.getCep(cep)
        return if (cachedCep != null) {
            cachedCep.toCep()
        } else {
            val response = viaCepService.getCep(cep)
            cepDao.insertCep(response.toCepEntity())
            response.toCep()
        }
    }

    override suspend fun getHistoryCeps(): List<Cep> {
        return cepDao.getHistoryCeps().map { it.toCep() }
    }

    override suspend fun deleteItemHistory(cep: String) {
        val cachedCep = cepDao.getCep(cep)
        cachedCep?.let { cepDao.delete(cachedCep) }
    }

    override suspend fun deleteAllHistory(){
        cepDao.deleteAll()

    }

}
