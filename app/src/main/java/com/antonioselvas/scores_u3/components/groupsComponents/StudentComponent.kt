package com.antonioselvas.scores_u3.components.groupsComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StudentComponent(
    name: String,
    lastName: String,
    score: Number,
    borderColor: Color,
    bgColor: Color
){
    Row (
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(20.dp)
            )
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 20.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,


    ){
        Column {
            Row {
                Text(
                    text = "Nombre: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(name,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row {
                Text(
                    text = "Apellido: ",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(lastName,
                    fontSize = 16.sp
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Promedio:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
                )
            Text("$score",
                fontSize = 16.sp
            )
        }


    }
}