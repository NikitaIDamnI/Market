package com.example.rettrofitpractick.presentation.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rettrofitpractick.databinding.FragmentProductBinding
import com.example.rettrofitpractick.presentation.rv.ProductAdapter
import com.squareup.picasso.Picasso


class ProductsFragment : Fragment() {
    private var _binding: FragmentProductBinding? = null
    private val binding: FragmentProductBinding
        get() = _binding ?: throw RuntimeException("FragmentProductBinding == null")

    private lateinit var token: String

    private val viewModelFactory by lazy{
        ProductVMFactory(requireActivity().application,token)
    }


    private val viewModel by lazy {
        ViewModelProvider(this,viewModelFactory)[ProductsViewModel::class.java]
    }

    private val adapter by lazy {
        ProductAdapter(requireActivity().application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseToken()
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
        initAdapter()
        initCardUser()
        initSearchView( )
    }

    private fun initAdapter() {
        binding.myRv.adapter = adapter
        viewModel.listProduct.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initCardUser() = with(binding) {
        viewModel.user.observe(viewLifecycleOwner, Observer  {
            tvFirstname.text = it.firstName
            tvLastname.text = it.lastName
            Picasso.get().load(it.image).into(imUser)
        })
    }

    private fun initSearchView(){
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                /*
                viewModel.searchProducts(newText?: "")
                viewModel.searchList.observe(viewLifecycleOwner, Observer {
                    adapter.submitList(it)
                })

                 */

                return true
            }

        })
    }

    private fun parseToken() {
        token = requireArguments().getString(TOKEN_KAY).toString()
        Log.d("ProductsFragment","token| $token")
    }


    companion object {
        fun newInstance(token: String): ProductsFragment {
            return ProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(TOKEN_KAY, token)
                }
            }
        }

        private const val TOKEN_KAY = "token_key"
    }
}