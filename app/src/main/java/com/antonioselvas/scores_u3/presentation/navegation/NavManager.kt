package com.antonioselvas.scores_u3.presentation.navegation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.antonioselvas.scores_u3.components.NavBar
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.ADD_STUDENT_ROUTE
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.AddView
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.DASHBOARD_ROUTE
import com.antonioselvas.scores_u3.presentation.views.dashboardViews.DashboardView
import com.antonioselvas.scores_u3.presentation.views.groupsViews.GROUP_ROUTE
import com.antonioselvas.scores_u3.presentation.views.groupsViews.GroupDetailsView
import com.antonioselvas.scores_u3.presentation.views.groupsViews.GroupsView
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
                GROUP_ROUTE
            ){
                GroupsView(navController, studentViewModel)
            }

            composable(
                ADD_STUDENT_ROUTE
            ) {
                AddView(navController, studentViewModel)
            }

            composable(
                route = "groupDetail/{grade}/{group}",
                arguments = listOf(
                    navArgument("grade") { type = NavType.IntType },
                    navArgument("group") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val grade = backStackEntry.arguments?.getInt("grade") ?: 0
                val group = backStackEntry.arguments?.getString("group") ?: ""
                GroupDetailsView(
                    navController = navController,
                    studentViewModel = studentViewModel,
                    grade = grade,
                    group = group
                )
            }


        }
    }

}

