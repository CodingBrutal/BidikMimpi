package com.example.bidikmimpi

import kotlinx.coroutines.withContext
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.example.bidikmimpi.models.RegisterLogin
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme
import com.example.bidikmimpi.ui.theme.blue3
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class registerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BidikmimpiTheme {
                RegisterScreen()
            }
        }
    }
}

@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit = {},
    onTextClick: () -> Unit = {},
    onHaveAccountClick: () -> Unit = {}
) {
    val coroutineScope = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm_password by remember { mutableStateOf("") }

    // State untuk menampilkan pesan error/sukses di bawah tombol Register
    var errorMessage by remember { mutableStateOf("") }

    // Toggle visibility password
    var passwordVisibility by remember { mutableStateOf(false) }

    // Form dinyatakan valid jika semua isian tidak kosong
    val isFormValid = email.isNotEmpty() && name.isNotEmpty() &&
            password.isNotEmpty() && confirm_password.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Gambar logo
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
                .padding(bottom = 50.dp, top = 0.dp)
                .fillMaxWidth()
        ) {
            // Layout tampilan register
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = blue3,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    ),
                    modifier = Modifier.padding(bottom = 20.dp, top = 5.dp)
                )

                // Input Email
                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                        errorMessage = "" // reset pesan error saat user mengetik
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

                // Input Name
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        errorMessage = "" // reset pesan error
                    },
                    placeholder = { Text("Name", color = Color.LightGray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "person",
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

                // Input Password
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        errorMessage = "" // reset pesan error
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

                // Input Confirm Password
                OutlinedTextField(
                    value = confirm_password,
                    onValueChange = {
                        confirm_password = it
                        errorMessage = "" // reset pesan error
                    },
                    placeholder = { Text("Confirm Password", color = Color.LightGray) },
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

                // Tombol Register
                Button(
                    onClick = {
                        errorMessage = ""

                        // Validasi form
                        when {
                            !isFormValid -> {
                                errorMessage = "Harap isi semua field."
                            }
                            password != confirm_password -> {
                                errorMessage = "Password dan Konfirmasi Password tidak cocok."
                            }
                            else -> {
                                coroutineScope.launch {
                                    try {
                                        // Panggil API di background thread
                                        val registerBody = RegisterLogin(
                                            email = email,
                                            password = password,
                                            confirm_password = confirm_password,
                                            name = name
                                        )
                                        val response = objApiService.apiService.register(registerBody)

                                        // Setelah dapat response, pindah ke main thread
                                        withContext(Dispatchers.Main) {
                                            if (response.isSuccessful) {
                                                val result = response.body()
                                                Log.d("REGISTER", "$result")

                                                if (result?.status == true) {
                                                    // Register sukses
                                                    onRegisterClick()
                                                } else {
                                                    // Register gagal (respons status = false)
                                                    errorMessage = result?.error ?: "Pendaftaran gagal."
                                                }
                                            } else {
                                                // Respons tidak sukses (kode 4xx, 5xx, dll.)
                                                errorMessage = "Gagal daftar. Code: ${response.code()}"
                                            }
                                        }
                                    } catch (e: Exception) {
                                        // Jika ada error, tampilkan di main thread juga
                                        withContext(Dispatchers.Main) {
                                            errorMessage = "Terjadi kesalahan. Coba lagi."
                                        }
                                    }
                                }
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2A9DF4),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Register",
                        fontWeight = FontWeight.Bold,
                    )
                }


                // Pesan error (atau sukses) ditampilkan di sini
                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    thickness = 1.dp,
                    color = Color.LightGray
                )

                Row {
                    Text(
                        text = "Punya akun?, Login ",
                        color = Color.LightGray,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                    Text(
                        text = "Now",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = blue3,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        modifier = Modifier.clickable {
                            onHaveAccountClick()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Register Preview")
@Composable
fun RegisterPreview() {
    BidikmimpiTheme {
        Surface {
            RegisterScreen(
                onRegisterClick = {},
                onHaveAccountClick = {}
            )
        }
    }
}
