package br.com.rm1234.ondeeh.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.rm1234.ondeeh.databinding.ActivityMainBinding
import br.com.rm1234.ondeeh.presentation.detail.DetalheActivity
import br.com.rm1234.ondeeh.presentation.extensions.addCepMask
import br.com.rm1234.ondeeh.presentation.history.CepHistoryActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etCep.addCepMask()

        binding.btPesquisar.setOnClickListener {
            val cep = binding.etCep.text.toString()
            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("CEP", cep)
            startActivity(intent)
        }

        binding.btHistorico.setOnClickListener {
            val intent = Intent(this, CepHistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
