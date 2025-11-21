package com.antonioselvas.scores_u3.presentation.views.groupsViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.antonioselvas.scores_u3.components.groupsComponents.GroupCard
import com.antonioselvas.scores_u3.viewmodel.StudentViewModel


const val GROUP_ROUTE = "Group"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupsView(navController: NavController, studentViewModel: StudentViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Grupos")
                }
            )
        }
    ) {
        GroupContent(it,studentViewModel, navController)
    }
}


@Composable
fun GroupContent(
    paddingValues: PaddingValues,
    studentViewModel: StudentViewModel,
    navController: NavController
){
    // Agrupar todos los estudiantes por grado
    val allStudents = studentViewModel.groupA +
            studentViewModel.groupB +
            studentViewModel.groupC
    val studentsByGrade = allStudents.groupBy { it.grade }

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        studentsByGrade.forEach { (grade, students) ->
            item {
                Text(
                    text = "Grado $grade",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            // Card para Grupo A
            item {
                val groupAStudents = students.filter { it.group == "A" }
                GroupCard(
                    group = "A",
                    grade = grade.toString(),
                    average = groupAStudents.map { it.score }.average().toInt(),
                    numberStudents = groupAStudents.size,
                    borderColor = Color.Blue,
                    onClick = { navController.navigate("groupDetail/$grade/A") }
                )
            }

            // Card para Grupo B
            item {
                val groupBStudents = students.filter { it.group == "B" }
                GroupCard(
                    group = "B",
                    grade = grade.toString(),
                    average = if(groupBStudents.isEmpty()) 0
                    else groupBStudents.map { it.score }.average().toInt(),
                    numberStudents = groupBStudents.size,
                    borderColor = Color.Green,
                    onClick = { navController.navigate("groupDetail/$grade/B") }
                )
            }

            // Card para Grupo C
            item {
                val groupCStudents = students.filter { it.group == "C" }
                GroupCard(
                    group = "C",
                    grade = grade.toString(),
                    average = if(groupCStudents.isEmpty()) 0
                    else groupCStudents.map { it.score }.average().toInt(),
                    numberStudents = groupCStudents.size,
                    borderColor = Color.Red,
                    onClick = { navController.navigate("groupDetail/$grade/C") }
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

