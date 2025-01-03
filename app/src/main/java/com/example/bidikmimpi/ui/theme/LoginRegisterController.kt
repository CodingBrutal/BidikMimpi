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

enum class Screen {
    Login,
    Register,
    Menu
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
        }
    }
}
