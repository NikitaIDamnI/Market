package com.example.rettrofitpractick.presentation.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rettrofitpractick.databinding.FragmentProductBinding
import com.example.rettrofitpractick.presentation.rv.ProductAdapter


class ProductsFragment : Fragment() {
    private var _binding: FragmentProductBinding? = null
    private val binding: FragmentProductBinding
        get() = _binding ?: throw RuntimeException("FragmentProductBinding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[ProductsViewModel::class.java]
    }

    private val adapter  by lazy {
        ProductAdapter(requireActivity().application)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myRv.adapter = adapter
        viewModel.listProduct.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

    }


    companion object{
        fun newInstance(token:String): ProductsFragment{
          return ProductsFragment().apply {
              arguments = Bundle().apply {
                  putString(TOKEN_KAY,token)
              }
          }
        }

        private const val TOKEN_KAY = "token_key"
    }
}