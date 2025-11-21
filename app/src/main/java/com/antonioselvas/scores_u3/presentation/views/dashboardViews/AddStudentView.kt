package com.antonioselvas.scores_u3.presentation.views.dashboardViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.antonioselvas.scores_u3.components.Dropdown
import com.antonioselvas.scores_u3.viewmodel.StudentViewModel


const val ADD_STUDENT_ROUTE = "AddView"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(navControler: NavController, viewModel: StudentViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Agregar estudiante")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {navControler.navigate("DashboardView")}
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {

        ContentAdd(it,viewModel, navControler)
    }
}


@Composable
fun ContentAdd(
    paddingValues: PaddingValues,
    viewModel: StudentViewModel,
    navControler: NavController
){
    var group by remember { mutableStateOf("") }

    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var grade by remember { mutableStateOf("") }
    var score by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Nombre")
            }
        )
        OutlinedTextField(
            value = lastName,
            onValueChange = {
                lastName = it
            },
            label = {
                Text("Apellidos")
            }
        )
        OutlinedTextField(
            value = grade,
            onValueChange = {
                grade = it
            },
            label = {
                Text("Grado")
            }
        )
        Dropdown(
            mSelectedText = group,
            onSelected = { option -> group = option },
        )
        OutlinedTextField(
            value = score,
            onValueChange = {
                score = it
            },
            label = {
                Text("Promedio")
            }
        )

        Button(
            onClick = {
                viewModel.addStudent(
                    name = name,
                    lastName = lastName,
                    grade = grade.toInt(),
                    group = group,
                    score = score.toFloat()
                )
                navControler.navigate("Dashboard")
            }
        ) {
            Text("Guardar")
        }
    }

}