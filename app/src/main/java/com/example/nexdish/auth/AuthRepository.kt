package com.example.nexdish.auth

import android.util.Log
import com.example.nexdish.data.AuthService

class AuthRepository(
    private val service: AuthService = AuthService()
) {
    suspend fun login(email: String, password: String) = service.login(email, password)

    suspend fun register(email: String, password: String, name: String): Boolean {
        return try {
            // FirebaseAuth.createUserWithEmailAndPassword()가 내부에서 실행됨
            service.register(email, password, name)
        } catch (e: Exception) {
            // ✅ 여기 추가!
            Log.e("AuthRepository", "Register failed: ${e.message}", e)
            false
        }
    }
}
