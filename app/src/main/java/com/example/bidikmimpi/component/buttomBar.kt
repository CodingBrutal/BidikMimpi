package com.example.bidikmimpi.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidikmimpi.R
import com.example.bidikmimpi.ui.theme.blue1

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavItemClick: (String) -> Unit
) {
    val navItems = listOf(
        NavItem(
            title = "Home",
            icon = R.drawable.ic_home_default,
            selectedIcon = R.drawable.ic_home_selected,
            route = "home"
        ),
        NavItem(
            title = "Ranking",
            icon = R.drawable.ranking_deefault,
            selectedIcon = R.drawable.ranking_selected,
            route = "ranking"
        ),
        NavItem(
            title = "Inbox",
            icon = R.drawable.pesan_default,
            selectedIcon = R.drawable.pesan_selected,
            route = "inbox"
        ),
        NavItem(
            title = "Profile",
            icon = R.drawable.profile_default,
            selectedIcon = R.drawable.profile_selected,
            route = "profile"
        )
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 8.dp
    ) {
        navItems.forEach { item ->
            val isSelected = currentRoute == item.route
            BottomNavigationItem(
                icon = {
                    val iconResource = if (isSelected) item.selectedIcon else item.icon
                    Image(
                        painter = painterResource(id = iconResource),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
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
                selectedContentColor = blue1,
                unselectedContentColor = Color.Gray
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: Int,
    val selectedIcon: Int,
    val route: String
)

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(currentRoute = "home", onNavItemClick = {})
}
