package br.com.rm1234.ondeeh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.rm1234.ondeeh.data.local.entity.CepEntity
import br.com.rm1234.ondeeh.domain.model.Cep


@Dao
interface CepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCep(cep: CepEntity)

    @Query("SELECT * FROM cep_table WHERE cep = :cep LIMIT 1")
    suspend fun getCep(cep: String): CepEntity?

    @Query("SELECT * FROM cep_table ORDER BY uf ASC")
    suspend fun getHistoryCeps(): List<CepEntity>

    @Delete
    suspend fun delete(cep: CepEntity)

    @Query("DELETE FROM cep_table")
    suspend fun deleteAll()
}
