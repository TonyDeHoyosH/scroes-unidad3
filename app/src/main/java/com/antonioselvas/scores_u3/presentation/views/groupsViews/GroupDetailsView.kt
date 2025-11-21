package com.antonioselvas.scores_u3.presentation.views.groupsViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.antonioselvas.scores_u3.components.groupsComponents.StudentComponent
import com.antonioselvas.scores_u3.viewmodel.StudentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupDetailsView(
    navController: NavController,
    studentViewModel: StudentViewModel,
    grade: Int,
    group: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Detalles Grupo $group - Grado $grade") })
        }
    ) { innerPadding ->
        GroupDetailContent(
            paddingValues = innerPadding,
            studentViewModel = studentViewModel,
            grade = grade,
            group = group
        )
    }
}

@Composable
fun GroupDetailContent(
    paddingValues: PaddingValues,
    studentViewModel: StudentViewModel,
    grade: Int,
    group: String
) {
    // Obtener estudiantes de ese grupo + grado
    val students = when (group.uppercase()) {
        "A" -> studentViewModel.groupA.filter { it.grade == grade }
        "B" -> studentViewModel.groupB.filter { it.grade == grade }
        "C" -> studentViewModel.groupC.filter { it.grade == grade }
        else -> emptyList()
    }
    // Ordenar por score descendente
    val sorted = students.sortedByDescending { it.score }
    val top3 = sorted.take(3)
    // El peor (puede ser emptyList)
    val worst = sorted.lastOrNull()

    Column(
        Modifier
            .padding(paddingValues)
            .padding(20.dp)
    ) {
        Text("Top 3 alumnos", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(10.dp))
        top3.forEach {
            StudentComponent(
                name = it.name,
                lastName = it.lastName,
                score = it.score,
                borderColor = Color(0xFF4CAF50), // Verde, mejor alumno
                bgColor = Color(0xFF4CAF50).copy(alpha = 0.15f)
            )
            Spacer(Modifier.height(6.dp))
        }
        Spacer(Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(Modifier.height(16.dp))
        Text("Peor alumno", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(10.dp))
        if (worst != null) {
            StudentComponent(
                name = worst.name,
                lastName = worst.lastName,
                score = worst.score,
                borderColor = Color(0xFFFF5252), // Rojo, peor alumno
                bgColor = Color(0xFFFF5252).copy(alpha = 0.15f)
            )
        } else {
            Text("Sin alumnos en este grupo")
        }
    }
}