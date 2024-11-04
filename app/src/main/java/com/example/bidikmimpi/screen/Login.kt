package com.example.bidikmimpi.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import com.example.bidikmimpi.R
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.bidikmimpi.ui.theme.blue3

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
    onTextNowClick: () -> Unit = {}
) {
    // State untuk menyimpan input pengguna
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val passwordVisibility by remember { mutableStateOf(false) }
    //val context = LocalContext.current




    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Menyelaraskan konten di tengah secara horizontal
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), // Menggunakan painterResource dengan id yang benar
            contentDescription = "Logo", // Menambahkan deskripsi konten untuk aksesibilitas
            modifier = Modifier
                .size(250.dp)
                .padding(bottom = 10.dp)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceBright,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            ),
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .padding(bottom = 180.dp, top = 0.dp)
                .fillMaxWidth()
        )  {
            // Layout tampilan login
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = blue3
                    ),
                    modifier = Modifier.padding(bottom = 20.dp, top = 5.dp),

                    )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
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

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("password", color = Color.LightGray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "lock",
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
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = if (passwordVisibility) R.drawable.eye else R.drawable.hideeye),
                            contentDescription = "Password visibility icon",
                            tint = Color.LightGray,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    shape = RoundedCornerShape(12.dp)
                )
                Text(
                    text = "Forgot password?",
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                    color = blue3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp)


                )

                Button(
                    onClick = {
                        onLoginClick()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),

                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2A9DF4), // Warna latar belakang tombol
                        contentColor = Color.White // Warna teks tombol
                    )
                ) {
                    Text(
                        "Login",
                        fontWeight = FontWeight.Bold,

                        )
                }
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    thickness = 1.dp,
                    color = Color.LightGray
                )
                Row {
                    Text(
                        text = "ew user?, Register",
                        color = Color.LightGray
                    )
                    Text(text = " ")
                    Text(
                        text = "Now",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = blue3,
                        textDecoration = TextDecoration.Underline,

                        modifier = Modifier
                            .clickable {
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
    Column {
        LoginScreen(onTextNowClick = {}, onLoginClick = {})
    }
}
