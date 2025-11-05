package com.example.nexdish.auth

import com.example.nexdish.data.AuthService

class AuthRepository(
    private val service: AuthService = AuthService()
) {
    suspend fun login(email: String, password: String) = service.login(email, password)
    suspend fun register(email: String, password: String, name: String) = service.register(email, password, name)
}
