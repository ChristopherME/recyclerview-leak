package com.sample.leak

import androidx.recyclerview.widget.RecyclerView
import com.sample.leak.databinding.ItemNumberBinding

class MyHolder(
    private val binding: ItemNumberBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: String) {
        binding.setVariable(BR.number, model)
        binding.executePendingBindings()
    }
}