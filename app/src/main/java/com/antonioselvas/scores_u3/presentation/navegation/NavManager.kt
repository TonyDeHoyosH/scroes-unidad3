package com.antonioselvas.scores_u3.presentation.navegation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.antonioselvas.scores_u3.components.NavBar



@Composable
fun NavManager( ){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavBar(navController)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = "Dashboard"
        ){
            composable(
                "Dashboard"
            ){

            }

            composable(
                "Groups"
            ){

            }


        }
    }

}

