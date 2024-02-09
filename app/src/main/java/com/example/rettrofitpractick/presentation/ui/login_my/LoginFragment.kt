package com.example.rettrofitpractick.presentation.ui.login_my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rettrofitpractick.R
import com.example.rettrofitpractick.data.network.ApiFactory
import com.example.rettrofitpractick.databinding.FragmentLoginBinding
import com.example.rettrofitpractick.presentation.products.ProductsFragment

class LoginFragment : Fragment() {


    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val apiService by lazy {
        ApiFactory.apiService
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.bLogin.setOnClickListener() {

                val username = binding.username.text.toString()
                val password = binding.password.text.toString()
                viewModel.auth(username, password)

                viewModel.loginStatus.observe(viewLifecycleOwner, Observer {
                    if (it.authorizationStatus){
                        requireActivity().supportFragmentManager.beginTransaction()
                           .replace(R.id.container_activity,ProductsFragment.newInstance(it.token))
                           .addToBackStack(null)
                           .commit()
                    }
                })

            viewModel.loadData.observe(viewLifecycleOwner, Observer {loadData->
                if(loadData){
                    binding.loading.visibility = View.VISIBLE
                }else{
                    binding.loading.visibility = View.GONE

                }
            })





        }


    }


}

