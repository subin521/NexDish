package com.example.nexdish.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexdish.auth.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val authService = AuthService()
    private val authRepository = AuthRepository()   // 🔥 추가: 로그인/회원가입 처리 담당

    // 로그인 상태
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState = _loginState.asStateFlow()

    // 회원가입 상태
    private val _registerState = MutableStateFlow<Boolean?>(null)
    val registerState = _registerState.asStateFlow()


    // 🔥 로그인 처리 로직
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading

            try {
                // AuthRepository 에서 로그인 처리
                val result = authRepository.login(email, password)

                if (result) {
                    _loginState.value = LoginState.Success
                } else {
                    _loginState.value = LoginState.Error("로그인 실패")
                }

            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message)
            }
        }
    }


    // 🔥 회원가입 처리 로직
    fun register(email: String, password: String, name: String) {
        viewModelScope.launch {
            try {
                val result = authRepository.register(email, password, name)
                _registerState.value = result     // Boolean? 반환
            } catch (e: Exception) {
                _registerState.value = false
            }
        }
    }
}