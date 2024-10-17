package com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.GETwith_Coroutine.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.POSTPUTDELETE.Model.PostmodelItem

import com.shital.myapplication.designs.MVVM.RecycleviewWithRetrofit.POSTPUTDELETE.Repository.RepositoryPOST
import kotlinx.coroutines.launch

class ViewModelPostMethod(private val post: RepositoryPOST) : ViewModel() {
    val myResponse: MutableLiveData<PostmodelItem> = MutableLiveData()

    val delete= MutableLiveData<Int>()
    fun getPost()
    {
        viewModelScope.launch{
            try{


                //*********** POST **********
                //val postRequest = post.postToServer()
                //myResponse.postValue(postRequest.body())


                //*********** PUT **********
                //val putRequest = post.putRequest()
                //myResponse.postValue(putRequest.body())

                //*********** PATCH **********
                //val patchRequest = post.patchRequest()
                //myResponse.postValue(patchRequest.body())




                 //*********** DELETE **********
                val response = post.deleteRequest()
                delete.postValue(response.code())
                Log.d("main", "getPost: ${response}")

            }catch (e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }
}