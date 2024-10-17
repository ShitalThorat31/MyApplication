package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETMethod.repository.AnimalsRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.Repository.UserRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel.UserViewModel

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