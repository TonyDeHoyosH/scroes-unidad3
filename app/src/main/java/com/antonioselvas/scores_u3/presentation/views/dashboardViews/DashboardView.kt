package com.antonioselvas.scores_u3.presentation.views.dashboardViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.antonioselvas.scores_u3.components.groupsComponents.StudentComponent
import com.antonioselvas.scores_u3.viewmodel.StudentViewModel


const val DASHBOARD_ROUTE = "Dashboard"


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView(navController: NavHostController, studentViewModel: StudentViewModel) {
//    val students = studentViewModel.getAllGroups()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Dashboard")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(ADD_STUDENT_ROUTE)
                }
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) {

        DashboardContent(it, studentViewModel)
    }
}


@Composable
fun DashboardContent(paddingValues: PaddingValues, studentViewModel: StudentViewModel ){
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Grupo A", "Grupo B", "Grupo C")
    Column(
        modifier = Modifier.padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    onClick = { selectedIndex = index },
                    selected = index == selectedIndex,
                    label = { Text(label) }
                )
                
            }
        }
        when (selectedIndex) {
            0 -> ShowStudentsGroupA(studentViewModel)
        }
    }
}

@Composable
fun ShowStudentsGroupA(studentViewModel: StudentViewModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(18.dp)
    ) {
        items(studentViewModel.groupA){ student ->
            StudentComponent(
                name = student.name,
                lastName = student.lastName,
                score = student.score,
                borderColor = Color.Green,
                bgColor = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}