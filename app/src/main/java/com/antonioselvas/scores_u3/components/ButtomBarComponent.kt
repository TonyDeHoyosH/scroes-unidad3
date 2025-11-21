package com.antonioselvas.scores_u3.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PeopleAlt
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.antonioselvas.scores_u3.models.BottomNavItem
import com.antonioselvas.scores_u3.presentation.views.groupsViews.GROUP_ROUTE


@Composable
fun NavBar(navController: NavController){
    val items = listOf(
        BottomNavItem(
            title = "Dashboard",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavItem(
            title = GROUP_ROUTE,
            selectedIcon = Icons.Filled.PeopleAlt,
            unselectedIcon = Icons.Outlined.PeopleAlt,
            hasNews = false,
        ),
    )

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar{
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.title)
                },
                label = {
                    Text(text = item.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null){
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            }else if(item.hasNews){
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex){
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                }
            )
        }
    }
}