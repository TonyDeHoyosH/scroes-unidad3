package com.antonioselvas.scores_u3.presentation.views.groupsViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.antonioselvas.scores_u3.components.groupsComponents.StudentComponent

@Composable
fun GroupDetailsView(){
    Scaffold {
        GroupDetailContent(it)
    }
}

@Composable
fun GroupDetailContent(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        StudentComponent(
            name = "Luis",
            lastName = "Selvas",
            score = 98,
            borderColor = Color.Green,
            bgColor = Color.Green.copy(alpha = 0.2f)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDetail(){
    GroupDetailsView()
}