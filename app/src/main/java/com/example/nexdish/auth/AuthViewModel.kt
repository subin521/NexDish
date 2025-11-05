package com.example.nexdish.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexdish.data.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val authService = AuthService()

    private val _loginState = MutableStateFlow<Boolean?>(null)
    val loginState = _loginState.asStateFlow()

    private val _registerState = MutableStateFlow<Boolean?>(null)
    val registerState = _registerState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = authService.login(email, password)
        }
    }

    fun register(email: String, password: String, name: String) {
        viewModelScope.launch {
            _registerState.value = authService.register(email, password, name)
        }
    }
}
