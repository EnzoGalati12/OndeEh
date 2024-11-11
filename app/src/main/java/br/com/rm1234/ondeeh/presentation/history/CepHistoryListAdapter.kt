package br.com.rm1234.ondeeh.presentation.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rm1234.ondeeh.databinding.CepHistoryItemBinding
import br.com.rm1234.ondeeh.domain.model.Cep

class CepHistoryListAdapter(
    private val onDeleteClick: (Cep) -> Unit
) : RecyclerView.Adapter<CepHistoryListAdapter.CepViewHolder>() {

    private var ceps: List<Cep> = emptyList()

    class CepViewHolder(val binding: CepHistoryItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CepViewHolder {
        val binding = CepHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CepViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CepViewHolder, position: Int) {
        val currentCep = ceps[position]
        holder.binding.tvLinha1.text = "${currentCep.cep} - ${currentCep.logradouro}"
        holder.binding.tvLinha2.text = currentCep.uf
        holder.binding.buttonDelete.setOnClickListener { onDeleteClick(currentCep) }
    }

    override fun getItemCount() = ceps.size

    fun setCeps(ceps: List<Cep>) {
        this.ceps = ceps
        notifyDataSetChanged()
    }
}
