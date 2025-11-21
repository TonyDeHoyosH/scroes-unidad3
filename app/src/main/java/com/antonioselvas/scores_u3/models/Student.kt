package com.antonioselvas.scores_u3.models

data class Student(
    val id: String,
    val name: String,
    val lastName: String,
    val grade: Int,
    val group: String,
    val score: Float
)


data class ListOfTopStudents(
    val topBest: MutableList<TopStudent>,
    val topWorst: MutableList<TopStudent>
)
data class TopStudent(
    val name: String,
    val lastName: String,
    val score: Float
)