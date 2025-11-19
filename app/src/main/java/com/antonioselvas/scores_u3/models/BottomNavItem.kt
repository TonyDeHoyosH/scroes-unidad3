package com.antonioselvas.scores_u3.models
import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
