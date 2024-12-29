package com.meformer.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginScreen_performsLogin() {
        composeTestRule.setContent {
            LoginScreen(onLoginSuccess = {}, onLoginError = {})
        }

        composeTestRule.onNodeWithText("Email").performTextInput("test@example.com")
        composeTestRule.onNodeWithText("Password").performTextInput("password")
        composeTestRule.onNodeWithText("Login").performClick()

        // Add assertions to verify behavior
    }
}