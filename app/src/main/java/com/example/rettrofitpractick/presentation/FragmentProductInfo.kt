package com.example.rettrofitpractick.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rettrofitpractick.R


class FragmentProductInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_info, container, false)
    }





    private fun getProductId():Int{
        return requireArguments().getInt(PRODUCT_KAY)
    }
    companion object {
        fun newInstance(productId : Int): FragmentProductInfo {
            return FragmentProductInfo().apply {
                arguments = Bundle().apply {
                    putInt(PRODUCT_KAY, productId)
                }
            }
        }
        private const val PRODUCT_KAY = "product_key"
    }
}