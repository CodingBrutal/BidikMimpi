package com.example.bidikmimpi.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bidikmimpi.screen.DefaultPreview
import com.example.bidikmimpi.RegisterScreen
import com.example.bidikmimpi.screen.LoginScreen
import com.example.bidikmimpi.screen.ResetPass

enum class Screen {
    Login,
    Register,
    Menu,
    ResetPass,
}

@Composable
fun LoginRegisterController(
    navController: NavHostController
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.name) {
                LoginScreen(
                    onLoginClick = {
                        navController.navigate(Screen.Menu.name)
                    },
                    onTextNowClick = {
                        navController.navigate(Screen.Register.name)
                    },
                    onForgotPassClick = {
                        navController.navigate(Screen.ResetPass.name)
                    }

                )
            }
            composable(Screen.Register.name) {
                RegisterScreen(
                    onHaveAccountClick = {
                        navController.navigate(Screen.Login.name)
                    }
                )
            }
            composable(Screen.Menu.name) {
                DefaultPreview()
            }
            composable(Screen.ResetPass.name) {
                ResetPass(
                    onLoginClick = {
                        navController.navigate(Screen.Login.name)
                    },
                    onKirimOtpClick = {
                        navController.navigate(Screen.ResetPass.name)
                    }
                )
            }
        }
    }
}
