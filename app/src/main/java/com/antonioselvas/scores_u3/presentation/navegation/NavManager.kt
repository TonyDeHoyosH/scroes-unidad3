package com.antonioselvas.scores_u3.presentation.navegation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.antonioselvas.scores_u3.components.NavBar
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.ADD_STUDENT_ROUTE
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.AddView
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.DASHBOARD_ROUTE
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.DashboardView
import com.antonioselvas.scores_u3.viewmodel.StudentViewModel


@Composable
fun NavManager(studentViewModel: StudentViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavBar(navController)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = DASHBOARD_ROUTE
        ){
            composable(
                DASHBOARD_ROUTE
            ){
                DashboardView(navController, studentViewModel)
            }

            composable(
                "Groups"
            ){

            }

            composable(
                ADD_STUDENT_ROUTE
            ) {
                AddView(navController, studentViewModel)
            }


        }
    }

}

