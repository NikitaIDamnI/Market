package com.example.rettrofitpractick.presentation.products

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductVMFactory(
    private val application: Application,
    private val token : String
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if( modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
           return ProductsViewModel(application,token) as T
       }else{
           throw RuntimeException(
               "Unknown view model class $modelClass | make sure that you have passed the token ")
       }
    }
}