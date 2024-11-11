package br.com.rm1234.ondeeh.di

import androidx.room.Room
import br.com.rm1234.ondeeh.data.local.AppDatabase
import br.com.rm1234.ondeeh.data.remote.api.ViaCepService
import br.com.rm1234.ondeeh.data.repository.CepRepositoryImpl
import br.com.rm1234.ondeeh.domain.repository.CepRepository
import br.com.rm1234.ondeeh.domain.usecase.DeleteAllHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.DeleteItemHistoryUseCase
import br.com.rm1234.ondeeh.domain.usecase.GetHistoryCepUseCase
import br.com.rm1234.ondeeh.domain.usecase.GetCepUseCase
import br.com.rm1234.ondeeh.presentation.detail.DetalheViewModel
import br.com.rm1234.ondeeh.presentation.history.CepHistoryViewModel
import br.com.rm1234.ondeeh.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ViaCepService::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "cep_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().cepDao() }
}


val repositoryModule = module {
    single<CepRepository> { CepRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { GetCepUseCase(get()) }
    factory { GetHistoryCepUseCase(get()) }
    factory { DeleteItemHistoryUseCase(get()) }
    factory { DeleteAllHistoryUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { DetalheViewModel(get()) }
    viewModel { CepHistoryViewModel(get(), get(), get()) }
}

