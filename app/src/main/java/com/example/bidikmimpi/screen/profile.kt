package com.example.bidikmimpi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.shadow
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BidikmimpiTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        name = "fufufafa",
                        gmail = "fufufa@gmail.com",
                        jurusan = "Teknik Informatika",
                        profileImageResId = R.drawable.eye,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun ProfileScreen(
    name: String,
    gmail: String,
    jurusan: String,
    profileImageResId: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF187BCD))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "PROFIL",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Profile Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(40.dp)
                    .background(Color(0xFF2A9DF4))
                    .padding(30.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    // Foto Profil
                    Image(
                        painter = painterResource(id = profileImageResId),
                        contentDescription = "Foto Profil",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 8.dp)
                    )


                    ProfileItem(label = "Nama", value = name, labelColor = Color.Black, textColor = Color.Black)
                    ProfileItem(label = "Gmail", value = gmail, labelColor = Color.Black, textColor = Color.Black)
                    ProfileItem(label = "Jurusan", value = jurusan, labelColor = Color.Black, textColor = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "More",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Button(
                onClick = { /* TODO: Handle Help & Support click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Help & Support",
                    color = Color.Black
                )
            }
            Button(
                onClick = { /* TODO: Handle About App click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "About App",
                    color = Color.Black
                )
            }
        }
    }
}



@Composable
fun ProfileItem(label: String, value: String, labelColor: Color, textColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.labelMedium,
            color = labelColor
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor
        )

        HorizontalDivider(thickness = 1.dp, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    BidikmimpiTheme {
        ProfileScreen(
            name = "Fufufafa",
            gmail = "Fufufafa@gmail.com",
            jurusan = "Teknik Informatika",
            profileImageResId = R.drawable.eye
        )
    }
}