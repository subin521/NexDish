package com.example.nexdish.data

import android.util.Log
import kotlinx.coroutines.tasks.await

class AuthService {
    private val auth = FirebaseService.auth
    private val db = FirebaseService.db

    suspend fun login(email: String, password: String): Boolean {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }



    suspend fun register(email: String, password: String, name: String): Boolean {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid ?: return false

            val user = hashMapOf(
                "uid" to uid,
                "email" to email,
                "name" to name
            )
            db.collection("users").document(uid).set(user).await()

            true

        } catch (e: Exception) {
            Log.e("AuthService", "Register failed: ${e.message}", e)
            false
        }
    }

}
