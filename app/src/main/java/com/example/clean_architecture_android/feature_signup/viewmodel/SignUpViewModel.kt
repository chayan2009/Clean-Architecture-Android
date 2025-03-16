package com.example.clean_architecture_android.feature_signup.viewmodel

import androidx.lifecycle.ViewModel
import com.example.clean_architecture_android.core.common.ValidationUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _nameError = MutableStateFlow<String?>(null)
    val nameError: StateFlow<String?> = _nameError

    private val _emailError = MutableStateFlow<String?>(null)
    val emailError: StateFlow<String?> = _emailError

    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError: StateFlow<String?> = _passwordError

    fun onNameChange(newName: String) {
        _name.value = newName
        _nameError.value = ValidationUtil.validateName(newName)
    }

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
        _emailError.value = ValidationUtil.validateEmail(newEmail)
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
        _passwordError.value = ValidationUtil.validatePassword(newPassword)
    }

    fun validateForm(): Boolean {
        val nameValid = ValidationUtil.validateName(_name.value) == null
        val emailValid = ValidationUtil.validateEmail(_email.value) == null
        val passwordValid = ValidationUtil.validatePassword(_password.value) == null

        return nameValid && emailValid && passwordValid
    }
}
