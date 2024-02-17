package com.example.rettrofitpractick.presentation.products

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rettrofitpractick.domain.model.User

class ProductVMFactory(
    private val application: Application,
    private val user : User
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if( modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
           return ProductsViewModel(application,user) as T
       }else{
           throw RuntimeException(
               "Unknown view model class $modelClass | make sure that you have passed the token ")
       }
    }
}