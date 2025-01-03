package com.example.bidikmimpi

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.bidikmimpi.ui.theme.blue1
import com.example.bidikmimpi.ui.theme.blue2
import com.example.bidikmimpi.ui.theme.blue3

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

    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                .padding(bottom = 150.dp, top = 0.dp)
                .fillMaxWidth()
        ) {
            // Layout tampilan login
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Text(
                    text = "Register",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = blue3,
                        fontFamily = FontFamily(Font(R.font.poppins_bold))
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
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text("name", color = Color.LightGray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
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
                    placeholder = { Text("Password", color = Color.LightGray) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
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




                Button(
                    onClick = {},
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
                        "Register",
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
                        text = "Have Account?, Login ",
                        color = Color.LightGray,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )
                    Text(text = " ")
                    Text(
                        text = "Now",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = blue3,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        modifier = Modifier
                            .clickable {
                                onHaveAccountClick()
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Login and Register Preview")
@Composable
fun RegisterPreview() {
    Column {
        RegisterScreen()
    }
}







