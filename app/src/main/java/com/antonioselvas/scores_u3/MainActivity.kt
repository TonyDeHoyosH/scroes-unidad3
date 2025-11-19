package com.antonioselvas.scores_u3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.antonioselvas.scores_u3.presentation.navegation.NavManager
import com.antonioselvas.scores_u3.ui.theme.Scores_U3Theme
import com.antonioselvas.scores_u3.viewmodel.StudentViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val studentViewModel = ViewModelProvider(this)[StudentViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            Scores_U3Theme {
                NavManager(studentViewModel)
            }
        }
    }
}
