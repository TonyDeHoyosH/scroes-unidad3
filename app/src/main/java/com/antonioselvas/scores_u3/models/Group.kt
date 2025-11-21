package com.antonioselvas.scores_u3.models

data class Group(
    val group: String,
    val numberStudents: Int,
    val listOfStudents: List<Student> = mutableListOf<Student>()
)

data class Groups(
    val groupA: Group,
    val groupB: Group,
    val groupC: Group
)