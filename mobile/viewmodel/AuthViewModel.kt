package com.meformer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meformer.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    var authToken: String? = null
        private set

    fun login(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(email, password)
                authToken = response.token
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "An error occurred")
            }
        }
    }

    fun register(firstName: String, lastName: String, email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = authRepository.register(firstName, lastName, email, password)
                authToken = response.token
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "An error occurred")
            }
        }
    }
}