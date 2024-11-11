package br.com.rm1234.ondeeh.presentation.history

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rm1234.ondeeh.databinding.ActivityCepHistoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CepHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCepHistoryBinding

    private val viewModel: CepHistoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCepHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getHistory()

        viewModel.cepAllHistory.observe(this) {
            val adapter = CepHistoryListAdapter(onDeleteClick = {
                viewModel.delete(it.cep)
            })
            binding.rvHistory.adapter = adapter
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            adapter.setCeps(it)
        }

        binding.btDeleteAll.setOnClickListener {
            viewModel.deleteAll()
            viewModel.getHistory()

        }
    }
}