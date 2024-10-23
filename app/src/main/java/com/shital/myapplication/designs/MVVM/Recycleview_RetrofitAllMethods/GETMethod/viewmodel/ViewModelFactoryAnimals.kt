package com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shital.myapplication.designs.MVVM.Recycleview_RetrofitAllMethods.GETMethod.repository.AnimalsRepository

class ViewModelFactoryAnimals (private val animalsRepository: AnimalsRepository) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelAnimals::class.java)) {
            ViewModelAnimals(this.animalsRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }


}