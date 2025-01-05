package com.example.bidikmimpi.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidikmimpi.R
import com.example.bidikmimpi.component.BottomNavBar
import com.example.bidikmimpi.component.BackableTopBar
import com.example.bidikmimpi.component.StandardTopBar
import com.example.bidikmimpi.ui.theme.blue3

@Composable
fun PengajuanScreen() {

    Scaffold(
        topBar = {
            BackableTopBar(
                title = "Bidik Mimpi"
                , onBackClick = {}
            )
        },


        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(top = 40.dp).padding(paddingValues)) {
                pengajuanContent()
            }
        }


    )
}

@Composable
fun pengajuanContent(
    onKirimClick: () -> Unit = {},

){
    var parent_income by remember { mutableStateOf("") }
    var depedent by remember { mutableStateOf("") }
    var decent_house by remember { mutableStateOf("") }
    var average_score by remember { mutableStateOf("") }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.material3.MaterialTheme.colorScheme.surfaceBright,
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
            androidx.compose.material3.Text(
                text = "Isi Form",
                style = androidx.compose.material3.MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = blue3,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                ),
                modifier = Modifier.padding(bottom = 20.dp, top = 5.dp),

                )

            OutlinedTextField(
                value = average_score,
                onValueChange = {
                    if (it.isEmpty() || it.toFloatOrNull() != null) {
                        average_score = it
                    }
                },
                placeholder = { androidx.compose.material3.Text("Average Score", color = Color.LightGray) },
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value =parent_income,
                onValueChange = {
                    if (it.isEmpty() || it.toFloatOrNull() != null) {
                        average_score = it
                    }
                },
                placeholder = { androidx.compose.material3.Text("Parent Income", color = Color.LightGray) },
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = depedent,
                onValueChange = {
                    if (it.isEmpty() || it.toFloatOrNull() != null) {
                        average_score = it
                    }
                },
                placeholder = { androidx.compose.material3.Text("Depedent", color = Color.LightGray) },
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = decent_house,
                onValueChange = {
                    if (it.isEmpty() || it.toFloatOrNull() != null) {
                        average_score = it
                    }
                },
                placeholder = { androidx.compose.material3.Text("Decent House", color = Color.LightGray) },
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .border(
                        width = 2.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )


            androidx.compose.material3.Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),

                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2A9DF4), // Warna latar belakang tombol
                    contentColor = Color.White
                )
            ) {
                androidx.compose.material3.Text(
                    "Kirim",
                    fontWeight = FontWeight.Bold,

                    )
            }


        }
    }

}



@Preview(showBackground = true)
@Composable
fun PenagjuanScreenPreview() {
    PengajuanScreen()
}