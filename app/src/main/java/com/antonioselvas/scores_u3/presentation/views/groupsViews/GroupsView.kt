package com.antonioselvas.scores_u3.presentation.views.groupsViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.antonioselvas.scores_u3.components.groupsComponents.GroupCard


@Composable
fun GroupsView(){
    Scaffold {
        GroupContent(it)
    }
}


@Composable
fun GroupContent(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        GroupCard(
            group = "A",
            grade = "4",
            average = 98,
            numberStudents = 6,
            borderColor = MaterialTheme.colorScheme.primaryContainer
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    GroupsView()
}
