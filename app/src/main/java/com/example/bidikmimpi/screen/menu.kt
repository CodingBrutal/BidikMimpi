package com.example.bidikmimpi.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme
import com.example.bidikmimpi.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BidikmimpiTheme() {
                MainApp()
            }
        }
    }
}
// Tambahkan pada NavHost di dalam fungsi MainApp

@Composable
fun MainApp() {
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            MainBottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = {
                    selectedTab = it
                    when (it) {
                        0 -> navController.navigate("pengajuan")
                        1 -> navController.navigate("notifikasi")
                        2 -> navController.navigate("profile")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "pengajuan",
                Modifier.weight(1f)
            ) {
                composable("pengajuan") { HomeScreen(navController, "pengajuan", showAjukanButton = true) }
                composable("proses") { HomeScreen(navController, "proses", showAjukanButton = false) }
                composable("selesai") { HomeScreen(navController, "selesai", showAjukanButton = false) }
                composable("notifikasi") { NotificationScreen() } // Layar notifikasi baru
                composable("profile") {
                    ProfileScreen(
                        name = "FUfufafa",
                        nim = "12345678",
                        jurusan = "Teknik Informatika",
                        profileImageResId = R.drawable.user
                    )
                }
            }
        }
    }
}

@Composable
fun NotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.imbox), // Sesuaikan dengan gambar yang Anda inginkan
            contentDescription = "Notifikasi Kosong",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tidak ada notifikasi",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }
}


@Composable
fun HomeScreen(navController: NavController, selectedButton: String, showAjukanButton: Boolean) {
    var showDialog by remember { mutableStateOf(false) }
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var noHp by remember { mutableStateOf(TextFieldValue("")) }
    var lahir by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Bidik Mimpi",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavigationButton(
                text = "Pengajuan",
                isSelected = selectedButton == "pengajuan",
                onClick = { navController.navigate("pengajuan") }
            )
            NavigationButton(
                text = "Proses",
                isSelected = selectedButton == "proses",
                onClick = { navController.navigate("proses") }
            )
            NavigationButton(
                text = "Selesai",
                isSelected = selectedButton == "selesai",
                onClick = { navController.navigate("selesai") }
            )
        }

        if (showAjukanButton) {
            Spacer(modifier = Modifier.height(200.dp))
            Image(
                painter = painterResource(id = R.drawable.folder),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Button(
                onClick = { showDialog = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text("Ajukan Beasiswa")
            }
            //Tampilkan pop up
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Formulir Pengajuan Beasiswa") },
                    text = {
                        Column {
                            OutlinedTextField(
                                value = nama,
                                onValueChange = { nama = it },
                                label = { Text("Nama") }
                            )
                            OutlinedTextField(
                                value = lahir,
                                onValueChange = { lahir = it },
                                label = { Text("Tanggal Lahir") }
                            )
                            OutlinedTextField(
                                value = noHp,
                                onValueChange = { noHp = it },
                                label = { Text("No HP") }
                            )
                        }
                    },
                    confirmButton = {
                        TextButton(onClick = {
                            // Here you can handle the form submission, e.g., send data to a server
                            showDialog = false
                        }) { Text("Submit") }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDialog = false }) { Text("Cancel") }
                    }
                )
            }
        }
    }
}

@Composable
fun MainBottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
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
                selectedIconColor = Color.Blue,
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
                selectedIconColor = Color.Blue,
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
                selectedIconColor = Color.Blue,
                unselectedIconColor = Color.Gray,
                selectedTextColor = Color.Black,
                unselectedTextColor = Color.Gray
            )
        )
    }
}

@Composable
fun NavigationButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(horizontal = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.Blue else Color.Gray,
            contentColor = Color.White
        )
    ) {
        Text(text)
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
                    Image(
                        painter = painterResource(id = profileImageResId),
                        contentDescription = "Foto Profil",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(bottom = 8.dp)
                    )
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
            style = MaterialTheme.typography.titleMedium,
            color = labelColor,
            modifier = Modifier.padding(bottom = 4.dp)
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
fun DefaultPreview() {
    BidikmimpiTheme() {
        MainApp()
    }
}