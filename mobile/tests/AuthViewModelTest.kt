package com.meformer.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.meformer.repository.AuthRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class AuthViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val authRepository = mock(AuthRepository::class.java)
    private val authViewModel = AuthViewModel(authRepository)

    @Test
    fun `login success updates authToken`() = runBlocking {
        val email = "test@example.com"
        val password = "password"
        val token = "mockToken"

        `when`(authRepository.login(email, password)).thenReturn(AuthResponse(token))

        authViewModel.login(email, password, {}, {})
        assertEquals(token, authViewModel.authToken)
    }

    @Test
    fun `login failure calls onError`() = runBlocking {
        val email = "test@example.com"
        val password = "wrongPassword"

        `when`(authRepository.login(email, password)).thenThrow(RuntimeException("Invalid credentials"))

        var errorMessage: String? = null
        authViewModel.login(email, password, {}, { errorMessage = it })

        assertEquals("Invalid credentials", errorMessage)
    }
}