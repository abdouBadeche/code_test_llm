package com.meformer.repository

import com.meformer.network.AuthApi
import com.meformer.network.LoginRequest
import com.meformer.network.RegisterRequest

class AuthRepository(private val authApi: AuthApi) {
    suspend fun login(email: String, password: String) =
        authApi.login(LoginRequest(email, password))

    suspend fun register(firstName: String, lastName: String, email: String, password: String) =
        authApi.register(RegisterRequest(firstName, lastName, email, password))
}