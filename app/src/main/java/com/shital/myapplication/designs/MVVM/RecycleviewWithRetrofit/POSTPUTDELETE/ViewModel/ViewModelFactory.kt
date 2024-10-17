package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.POSTPUTDELETE.Repository.RepositoryPOST

class ViewModelFactory(private val postrepo: RepositoryPOST) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ViewModelPostMethod::class.java)) {
            ViewModelPostMethod(this.postrepo) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }


}