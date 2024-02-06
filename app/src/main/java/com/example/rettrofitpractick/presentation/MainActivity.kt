package com.example.rettrofitpractick.presentation

import com.example.rettrofitpractick.presentation.rv.ProductAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rettrofitpractick.databinding.ActivityMainBinding
import com.example.rettrofitpractick.data.network.ApiFactory
import com.example.rettrofitpractick.data.network.ApiService
import com.example.rettrofitpractick.presentation.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val adapter = ProductAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.myRv.adapter = adapter
        viewModel.listProduct.observe(this){
            adapter.submitList(it)
    }




}


}