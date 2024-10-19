package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.Repository.ProductsRepository
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.Hilt.model.productsItem

import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
class ProductsViewModel @Inject constructor(private  val productsRepository: ProductsRepository):ViewModel()
{

    val productsList: MutableLiveData<List<productsItem>> = MutableLiveData()

        fun getProducts()
        {

        viewModelScope.launch(){
            try {
                val response= productsRepository.getProducts()
                if (response.isSuccessful){
                    productsList.postValue(response.body())
                }
                else{
                    Log.d("main", "getPost: ${response.errorBody()}")
                }

            }
            catch (e:Exception)
            {
                Log.d("main", "getPost: ${e.message}")
            }
        }

    }
}