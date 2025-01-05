package com.example.bidikmimpi.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bidikmimpi.R
import com.example.bidikmimpi.ui.theme.blue1

@Composable
fun BackableTopBar(
    title: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White, // Ubah sesuai kebutuhan
    contentColor: Color = blue1 // Ubah sesuai kebutuhan atau definisikan blue1
) {
    TopAppBar(
        title = { Text(text = title,
            fontWeight = FontWeight.Bold,
            color = contentColor) },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.back),

                    contentDescription = "Kembali",
                    tint = contentColor,
                    modifier = Modifier.
                    width(27.dp)
                )
            }
        },
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = 4.dp,
        modifier = modifier
    )
}

@Composable
fun StandardTopBar(
    title: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    contentColor: Color = blue1,
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
    actions: @Composable () -> Unit = {}
) {
    TopAppBar(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        title = {
            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = contentColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        actions = {
            actions()
        },
        modifier = modifier
    )
}


/**
 * Preview untuk BackableTopBar.
 */
@Preview(showBackground = true)
@Composable
fun BackableTopBarPreview() {
    BackableTopBar(
        title = "Preview Title",
        onBackClick = { /* Tidak melakukan apa-apa di Preview */ }
    )
}

@Preview(showBackground = true)
@Composable
fun StandardTopBarPreview() {
    StandardTopBar(
        title = "Standard TopBar",
    )
}