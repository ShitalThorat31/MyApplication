package com.shital.myapplication.designs.LoginRegis_Retrofit_Validation_withHilt.Firebase

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModelFirebase @Inject constructor(private val repository: AuthRepositoryFirebase) : ViewModel() {

    val authResult = MutableLiveData<Pair<Boolean, String?>>()

    val validationMessage = MutableLiveData<String>()

    fun validateForm(email: String, password: String, name: String? = null): Boolean {
        return when {
            email.isEmpty() -> {
                validationMessage.postValue("Email cannot be empty")
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                validationMessage.postValue("Invalid email address")
                false
            }
            password.length < 6 -> {
                validationMessage.postValue("Password must be at least 6 characters")
                false
            }
            name != null && name.isEmpty() -> {
                validationMessage.postValue("Name cannot be empty")
                false
            }
            else -> true
        }
    }

    fun signUp(email: String, password: String, name: String) {
        if (validateForm(email, password, name)) {

            repository.signUp(email, password, name) { success, message ->
                authResult.postValue(Pair(success, message))
            }
        }
    }

    fun login(email: String, password: String) {
        if (validateForm(email, password)) {
            repository.login(email, password) { success, message ->
                authResult.postValue(Pair(success, message))
            }
        }
    }
}
