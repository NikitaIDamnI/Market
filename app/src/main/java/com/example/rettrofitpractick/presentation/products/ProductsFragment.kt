package com.example.rettrofitpractick.presentation.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rettrofitpractick.databinding.FragmentProductBinding
import com.example.rettrofitpractick.domain.model.User
import com.example.rettrofitpractick.presentation.rv.ProductAdapter
import com.squareup.picasso.Picasso


class ProductsFragment : Fragment() {
    private var _binding: FragmentProductBinding? = null
    private val binding: FragmentProductBinding
        get() = _binding ?: throw RuntimeException("FragmentProductBinding == null")

    private lateinit var user: User

    private val viewModelFactory by lazy{
        ProductVMFactory(requireActivity().application,user)
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
        likeProduct()
    }


    private fun likeProduct(){
        adapter.onCheckBoxClickListener = object :ProductAdapter.OnCheckBoxClickListener{
            override fun onCheckBoxClick(productId: Int, favoriteStatus: Boolean) {
               viewModel.likeToFavoriteProduct(productId,favoriteStatus)
            }

        }
    }

    private fun initAdapter() {
        binding.myRv.adapter = adapter
        viewModel.listProduct.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initCardUser() = with(binding) {
            tvFirstname.text = user.firstName
            tvLastname.text = user.lastName
            Picasso.get().load(user.image).into(imUser)
    }

    private fun initSearchView(){
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                viewModel.searchProducts(newText?: "")
                viewModel.searchList.observe(viewLifecycleOwner, Observer {
                    adapter.submitList(it)
                })
                return true
            }

        })
    }

    private fun parseToken() {
        user = requireArguments().getParcelable<User>(USER_KAY)!!
    }


    companion object {
        fun newInstance(user: User): ProductsFragment {
            return ProductsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(USER_KAY, user)
                }
            }
        }
        private const val USER_KAY = "user_key"
    }
}