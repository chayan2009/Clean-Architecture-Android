package com.example.clean_architecture_android.feature_login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_architecture_android.core.common.ValidationUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _usernameError = MutableStateFlow<String?>(null)
    val usernameError: StateFlow<String?> = _usernameError

    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError: StateFlow<String?> = _passwordError

    private val _loginState = MutableStateFlow<Boolean?>(true)
    val loginState: StateFlow<Boolean?> = _loginState

    fun onUsernameChange(value: String) {
        _username.value = value
        _usernameError.value = ValidationUtil.validateName(value)
    }

    fun onPasswordChange(value: String) {
        _password.value = value
        _passwordError.value = ValidationUtil.validatePassword(value)
    }

    fun login() {
        _usernameError.value = ValidationUtil.validateName(username.value)
        _passwordError.value = ValidationUtil.validatePassword(password.value)

        if (_usernameError.value == null && _passwordError.value == null) {
            viewModelScope.launch {
                _loginState.value = true
            }
        }
    }
}

