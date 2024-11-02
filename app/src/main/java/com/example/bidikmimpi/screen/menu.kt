package com.example.bidikmimpi

import android.os.Bundle
import androidx.compose.ui.text.input.TextFieldValue

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bidikmimpi.ui.theme.BidikmimpiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BidikmimpiTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "pengajuan",
            Modifier.padding(innerPadding)
        ) {
            composable("pengajuan") { HomeScreen(navController, showAjukanButton = true) }
            composable("proses") { HomeScreen(navController, showAjukanButton = false) }
            composable("selesai") { HomeScreen(navController, showAjukanButton = false) }
            composable("imbox") { ImboScreen() }
            composable("profil") { ProfilScreen() }
        }
    }
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentDestination = remember { mutableStateOf("pengajuan") }

    BottomNavigation(
        modifier = Modifier
            .height(56.dp) // Mengatur tinggi
            .padding(3.dp)
            .offset(y = (-20).dp),
        backgroundColor = Color.White // Mengatur latar belakang menjadi transparan
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.home),

                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentDestination.value == "pengajuan") Color.Blue else Color.Gray // Warna ikon
                )
            },
            label = {
                Text(
                    "Home",
                    fontSize = 12.sp,
                    color = if (currentDestination.value == "pengajuan") Color.Blue else Color.Gray // Warna teks
                )
            },
            selected = currentDestination.value == "pengajuan",
            onClick = {
                navController.navigate("pengajuan") {

                    popUpTo("pengajuan") { inclusive = true }
                }
                currentDestination.value = "pengajuan"
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.imbox),
                    contentDescription = "Imbox",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentDestination.value == "imbox") Color.Blue else Color.Gray
                )
            },
            label = {
                Text(
                    "Imbox",
                    fontSize = 12.sp,
                    color = if (currentDestination.value == "imbox") Color.Blue else Color.Gray
                )
            },
            selected = currentDestination.value == "imbox",
            onClick = {
                navController.navigate("imbox") {
                    popUpTo("imbox") { inclusive = true }
                }
                currentDestination.value = "imbox"
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    painterResource(id = R.drawable.prfil),
                    contentDescription = "Profil",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentDestination.value == "profil") Color.Blue else Color.Gray
                )
            },
            label = {
                Text(
                    "Profil",
                    fontSize = 12.sp,
                    color = if (currentDestination.value == "profil") Color.Blue else Color.Gray
                )
            },
            selected = currentDestination.value == "profil",
            onClick = {
                navController.navigate("profil") {
                    popUpTo("profil") { inclusive = true }
                }
                currentDestination.value = "profil"
            }
        )
    }
}


@Composable
fun ImboScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Halaman Imbox")
    }
}

@Composable
fun ProfilScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Halaman Profil")
    }
}

@Composable
fun HomeScreen(navController: NavController, showAjukanButton: Boolean) {
    var selectedButton by remember { mutableStateOf("pengajuan") }
    var showDialog by remember { mutableStateOf(false) }
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var tanggalLahir by remember { mutableStateOf(TextFieldValue("")) }
    var noHp by remember { mutableStateOf(TextFieldValue("")) }

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
                onClick = {
                    navController.navigate("pengajuan")
                    selectedButton = "pengajuan"
                }
            )
            NavigationButton(
                text = "Proses",
                isSelected = selectedButton == "proses",
                onClick = {
                    navController.navigate("proses")
                    selectedButton = "proses"
                }
            )
            NavigationButton(
                text = "Selesai",
                isSelected = selectedButton == "selesai",
                onClick = {
                    navController.navigate("selesai")
                    selectedButton = "selesai"
                }
            )
        }

        if (showAjukanButton) {
            Spacer(modifier = Modifier.height(200.dp))
            Image(
                painter = painterResource(id = R.drawable.folder), // Pastikan resource ini ada
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )

            Button(
                onClick = { showDialog = true},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text("Ajukan Beasiswa")
            }
            // Popup Dialog
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
                                value = tanggalLahir,
                                onValueChange = { tanggalLahir = it },
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

@Preview(showBackground = true)
@Composable
fun MainAppPreview() {
    BidikmimpiTheme {
        MainApp()
    }
}
