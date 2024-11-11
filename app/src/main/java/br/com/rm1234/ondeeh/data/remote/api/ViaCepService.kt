package br.com.rm1234.ondeeh.data.remote.api

import br.com.rm1234.ondeeh.data.remote.model.CepResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("{cep}/json/")
    suspend fun getCep(@Path("cep") cep: String): CepResponse
}
