package com.shital.myapplication.designs.SignInUp_Retrofit_Validation.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AuthRepositoryFirebase @Inject constructor() {
private val auth: FirebaseAuth = FirebaseAuth.getInstance()
private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

fun signUp(email: String, password: String, name: String, callback: (Boolean, String?) -> Unit) {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser!!
                val userData = User(uid = user.uid, name = name, email = email)
                db.collection("users").document(user.uid).set(userData)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            callback(true, null)
                        } else {
                            callback(false, it.exception?.message)
                        }
                    }
            } else {
                callback(false, task.exception?.message)
            }
        }
}

fun login(email: String, password: String, callback: (Boolean, String?) -> Unit) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback(true, null)
            } else {
                callback(false, task.exception?.message)
            }
        }
}
}