package com.example.nexdish.auth

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    data class Error(val message: String? = null) : LoginState()
}
