package com.example.bidikmimpi.screen

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidikmimpi.R
import com.example.bidikmimpi.api.objApiService
import com.example.bidikmimpi.models.StrukturLogin
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme
import com.example.bidikmimpi.ui.theme.blue3
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BidikmimpiTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {},
    onTextNowClick: () -> Unit = {},
    onForgotPassClick: () -> Unit = {},
) {
    val coroutineScope = rememberCoroutineScope()

    // State untuk menyimpan input pengguna
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Toggle untuk visibility password
    var passwordVisibility by remember { mutableStateOf(false) }

    // State untuk menampilkan pesan error di bawah tombol Login
    var errorMessage by remember { mutableStateOf("") }

    // Jika email & password tidak kosong, maka tombol Login aktif
    val isFormValid = email.isNotEmpty() && password.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(250.dp)
                .padding(bottom = 10.dp)
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceBright
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .padding(bottom = 130.dp, top = 0.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = blue3,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    ),
                    modifier = Modifier.padding(bottom = 20.dp, top = 5.dp)
                )

                // Field Input Email
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        // Setel errorMessage kosong saat user mulai mengetik
                        errorMessage = ""
                    },
                    placeholder = { Text("Email", color = Color.LightGray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = "email",
                            tint = Color.LightGray
                        )
                    },
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                        .border(
                            width = 2.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp)
                )

                // Field Input Password
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        // Setel errorMessage kosong saat user mulai mengetik
                        errorMessage = ""
                    },
                    placeholder = { Text("Password", color = Color.LightGray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "lock",
                            tint = Color.LightGray
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(
                                id = if (passwordVisibility) R.drawable.eye else R.drawable.hideeye
                            ),
                            contentDescription = "Toggle password visibility",
                            tint = Color.LightGray,
                            modifier = Modifier
                                .size(24.dp)
                                .clickable {
                                    passwordVisibility = !passwordVisibility
                                }
                        )
                    },
                    // Menampilkan password jika passwordVisibility = true
                    visualTransformation = if (passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                        .border(
                            width = 2.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp)
                )

                Text(
                    text = "Forgot password?",
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                    color = blue3,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp)
                        .clickable {
                            onForgotPassClick()
                        }
                )

                // Tombol Login
                Button(
                    onClick = {
                        errorMessage = ""

                        // Validasi akhir, pastikan email & password terisi
                        if (isFormValid) {
                            coroutineScope.launch {
                                try {
                                    val loginBody = StrukturLogin(email, password)
                                    val response = objApiService.apiService.login(loginBody)

                                    if (response.isSuccessful) {
                                        val result = response.body()
                                        Log.d("LOGIN", "$result")

                                        if (result?.status == true) {
                                            // Login sukses
                                            onLoginClick()
                                        } else {
                                            // Login gagal, tampilkan error
                                            errorMessage = result?.error?.let {
                                                if (it == "No user found with this email") {
                                                    "Akun dengan email tersebut tidak ditemukan."
                                                } else {
                                                    it
                                                }
                                            } ?: ""
                                        }
                                    } else {
                                        // Respons tidak sukses (kode 4xx, 5xx, dll.)
                                        errorMessage = response.body()?.error.toString()
                                    }
                                } catch (e: Exception) {
                                    // Terjadi error saat memanggil API
                                    errorMessage = "Terjadi kesalahan. Coba lagi."
                                }
                            }
                        } else {
                            errorMessage = "Harap isi email dan password."
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2A9DF4),
                        contentColor = Color.White
                    ),
                    enabled = isFormValid  // tombol aktif jika form valid
                ) {
                    Text(
                        "Login",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    )
                }

                // Tampilkan errorMessage jika tidak kosong
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                Row {
                    Text(
                        text = "new user?, Register",
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Now",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = blue3,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        modifier = Modifier.clickable {
                            onTextNowClick()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Login and Register Preview")
@Composable
fun LoginScreenPreview() {
    BidikmimpiTheme {
        Surface {
            LoginScreen(
                onTextNowClick = {},
                onLoginClick = {},
                onForgotPassClick = {}
            )
        }
    }
}
