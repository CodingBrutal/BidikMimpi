package com.example.bidikmimpi.component


import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.bidikmimpi.R
import com.example.bidikmimpi.ui.theme.blue1
import com.example.bidikmimpi.ui.theme.blue3

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavItemClick: (String) -> Unit
) {
    val navItems = listOf(
        NavItem("Home", Icons.Default.Home, "home"),
        NavItem("Settings", Icons.Default.Settings, "settings"),
        NavItem("Profile", Icons.Default.Face, "profile")
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        navItems.forEach { item ->
            val isSelected = currentRoute == item.route
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) blue1 else Color.Gray // Warna ikon berdasarkan status
                    )
                },
                selected = isSelected,
                onClick = { onNavItemClick(item.route) },
                label = {
                    Text(
                        text = item.title,
                        color = if (isSelected) blue1 else Color.Gray,
                        fontFamily = FontFamily(Font(R.font.poppins_regular))
                    )


                },
                alwaysShowLabel = true,
                selectedContentColor = blue1, // Warna saat dipilih
                unselectedContentColor = Color.Gray // Warna saat tidak dipilih
            )
        }
    }
}


data class NavItem(val title: String, val icon: ImageVector, val route: String)
@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(currentRoute = "home", onNavItemClick = {})
}