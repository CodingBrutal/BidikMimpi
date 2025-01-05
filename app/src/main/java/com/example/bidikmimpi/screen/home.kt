package com.example.bidikmimpi.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidikmimpi.component.StandardTopBar
import com.example.bidikmimpi.component.BottomNavBar
import com.example.bidikmimpi.R


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            StandardTopBar(
                title = "Bidik Mimpi"

            )
        },

        content = { innerPadding ->
            // Konten utama
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    // 1. Gambar
                    Image(
                        painter = painterResource(id = R.drawable.ajukan),
                        contentDescription = "Sample Image",
                        modifier = Modifier
                            .size(128.dp)
                            .padding(bottom = 16.dp)
                    )

                    // 2. Teks
                    Text(
                        text = "Silahakan Mengajukan Beasiswa!",
                        style = MaterialTheme.typography.h6, // Anda bisa menyesuaikan gaya teks
                        modifier = Modifier.padding(bottom = 16.dp) // Spasi antara teks dan tombol
                    )

                    // 3. Tombol
                    Button(
                        onClick = {
                            // Aksi saat tombol diklik
                            // Contoh: Navigasi ke halaman detail

                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height( 48.dp)
                    ) {
                        Text(text = "Klik Saya")
                    }
                }
            }

        },
        bottomBar = {
            BottomNavBar(currentRoute = "home", onNavItemClick = {})
        }

    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}