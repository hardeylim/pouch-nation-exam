package com.example.pouchnationexam.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pouchnationexam.databinding.ItemTicketTypeBinding
import com.example.pouchnationexam.usecase.api.Events.TicketType

class TicketAdapter(
    private val ticketTypes: List<TicketType>
) : RecyclerView.Adapter<TicketAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketTypeBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = ticketTypes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ticketTypes[position])
    }

    inner class ViewHolder(val binding: ItemTicketTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(type: TicketType) {
            binding.item = type
        }
    }
}