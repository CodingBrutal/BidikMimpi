package com.example.bidikmimpi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.shadow
import androidx.navigation.compose.rememberNavController
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme
import com.example.bidikmimpi.ui.theme.LoginRegisterController


class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BidikmimpiTheme() {
                var selectedTab by remember { mutableStateOf(0) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(selectedTab = selectedTab, onTabSelected = { selectedTab = it })
                    }
                ) { innerPadding ->
                    ProfileScreen(
                        name = "fufufafa",
                        nim = "12345678",
                        jurusan = "Teknik Informatika",
                        profileImageResId = R.drawable.user,
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
    nim: String,
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

                    // Menampilkan NIM dan Jurusan
                    ProfileItem(label = "Nama", value = name, labelColor = Color.Black, textColor = Color.Black)
                    ProfileItem(label = "NIM", value = nim, labelColor = Color.Black, textColor = Color.Black)
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

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar(
        containerColor = Color.White, // Background warna gelap
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Beranda",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Beranda") },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.ThumbUp,
                    contentDescription = "Notifikasi",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Notifikasi") },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray
            )
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profil",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text("Profil") },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Black,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray
            )
        )
    }
}

@Composable
fun ProfileScreenWithScaffoldPreview() {
    BidikmimpiTheme() {
        var selectedTab by remember { mutableStateOf(2) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigationBar(selectedTab = selectedTab, onTabSelected = { selectedTab = it })
            }
        ) { innerPadding ->
            ProfileScreen(
                name = "Fufufafa",
                nim = "2113020024",
                jurusan = "Teknik Informatika",
                profileImageResId = R.drawable.user,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenWithScaffoldPreviewPreview() {
    ProfileScreenWithScaffoldPreview()
}