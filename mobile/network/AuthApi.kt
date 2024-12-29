package com.meformer.network

import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val email: String, val password: String)
data class RegisterRequest(val firstName: String, val lastName: String, val email: String, val password: String)
data class AuthResponse(val token: String)

interface AuthApi {
    @POST("/auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @POST("/auth/register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse
}