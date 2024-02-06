package com.example.rettrofitpractick.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.example.rettrofitpractick.domain.model.ProductModel

object ProductDiffCallback : DiffUtil.ItemCallback<ProductModel>() {
    override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
        return oldItem == newItem
    }
}