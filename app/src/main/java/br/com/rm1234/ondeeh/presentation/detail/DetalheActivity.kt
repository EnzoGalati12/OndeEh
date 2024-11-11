package br.com.rm1234.ondeeh.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.rm1234.ondeeh.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetalheActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetalheViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cep = intent.getStringExtra("CEP") ?: ""
        viewModel.fetchCep(cep)

        viewModel.cepData.observe(this, Observer { cep ->
            binding.tvBairro.text = cep.bairro
            binding.tvLocalidade.text = cep.localidade
            binding.tvLogradouro.text = cep.logradouro
            binding.tvUF.text = cep.uf
        })
    }
}