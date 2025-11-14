package com.antonioselvas.scores_u3.components.groupsComponents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GroupCard(
    group: String,
    grade: String,
    average: Number,
    numberStudents: Number,
    borderColor: Color,
    onClick: () -> Unit
){
    Row (
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 20.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            ) {

                Text(
                    text = grade,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(
                    text = group,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Button(
                modifier = Modifier
                    .width(160.dp),
                onClick ={
                    onClick()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text("Ver grupo")
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
            Icon(
                imageVector = Icons.Default.PeopleAlt,
                contentDescription = "",
            )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text("$numberStudents",
                 fontSize = 20.sp,
                 )
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                "Promedio",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text("$average",
                fontSize = 16.sp,
                )
        }


    }
}


