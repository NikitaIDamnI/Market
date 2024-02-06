package com.example.rettrofitpractick.presentation.rv
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import com.example.rettrofitpractick.domain.model.ProductModel
import com.example.rettrofitpractick.databinding.ItemRvBinding

class ProductAdapter(private val context: Context) :
    ListAdapter<ProductModel, ProductViewHolder>(ProductDiffCallback) {

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemRvBinding.inflate(
            LayoutInflater.from(context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        Log.d("coin","$product")
        with(holder.binding) {
            with(product) {
                textView2.text = product.title
                textView3.text = product.category
                Picasso.get().load(product.images[0]).into(imageView3)
                root.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: ProductModel)
    }
}