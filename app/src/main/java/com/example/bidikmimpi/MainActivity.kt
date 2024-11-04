package com.example.bidikmimpi


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.bidikmimpi.screen.LoginScreen
import com.example.bidikmimpi.ui.theme.LoginRegisterController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BidikmimpiTheme {
                val navController = rememberNavController()
                LoginRegisterController(navController = navController)
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    BidikmimpiTheme {
        LoginScreen(onTextNowClick = {},onLoginClick = {})
    }
}
