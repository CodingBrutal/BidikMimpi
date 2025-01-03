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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.bidikmimpi.ui.theme.blue3

class ResetPassActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BidikmimpiTheme {
                ResetPass()
            }
        }
    }
}

@Composable
fun ResetPass(
    onLoginClick: () -> Unit = {},
    onKirimOtpClick: () -> Unit = {},

) {
    // State untuk menyimpan input pengguna
    var email by remember { mutableStateOf("") }
    var otp by remember { mutableStateOf("") }
    val passwordVisibility by remember { mutableStateOf(false) }
    //val context = LocalContext.current




    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

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
                    text = "Reset Password",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = blue3,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                    ),
                    modifier = Modifier.padding(bottom = 20.dp, top = 5.dp)

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
                    value = otp,
                    onValueChange = { otp = it },
                    placeholder = { Text("kode otp", color = Color.LightGray) },
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
//                        Icon(
//                            painter = painterResource(id = if (passwordVisibility) R.drawable.eye else R.drawable.hideeye),
//                            contentDescription = "Password visibility icon",
//                            tint = Color.LightGray,
//                            modifier = Modifier.size(24.dp)
//                        )
                    },
                    shape = RoundedCornerShape(12.dp)
                )
                Text(
                    text = "Kirim Otp?",
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                    color = blue3,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp)
                        .clickable {
                            onKirimOtpClick()
                        }


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
                        "Reset Password",
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
                        )
                }
            }
        }
    }

}

@Preview(showBackground = true, name = "Login and Register Preview")
@Composable
fun ResetPassPreview() {
    Column {
        ResetPass(onKirimOtpClick = {}, onLoginClick = {})
    }
}
