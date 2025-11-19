package com.antonioselvas.scores_u3.viewmodel


import androidx.lifecycle.ViewModel
import com.antonioselvas.scores_u3.models.Student


data class Groups(
    val groupA: MutableList<Student>,
    val groupB: MutableList<Student>,
    val groupC: MutableList<Student>
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

class StudentViewModel : ViewModel(){

    private var _groupA: MutableList<Student> = mutableListOf()
    val groupA: MutableList<Student> = _groupA

    private var _groupB: MutableList<Student> = mutableListOf()
    val groupB: MutableList<Student> = _groupB

    private var _groupC: MutableList<Student> = mutableListOf()
    val groupC: MutableList<Student> = _groupC

    fun getAllGroups(): Groups {
        return Groups(
            groupA = groupA,
            groupB = groupB,
            groupC = groupC
        )
    }

    fun addStudent(name: String,lastName: String,grade: Int,group: String,score: Float){
        var id: String = ""
        when (group){
            "A" -> id = (groupA.size + 1).toString()
            "B" -> id = (groupB.size + 1).toString()
            "C" -> id = (groupC.size + 1).toString()
        }

        val newStudent = Student(
            id = id,
            name = name,
            lastName = lastName,
            grade = grade,
            group = group,
            score = score
        )

        when (group){
            "A" -> groupA.add(newStudent)
            "B" -> groupB.add(newStudent)
            "C" -> groupC.add(newStudent)
        }

    }

    fun getGroupA(): ListOfTopStudents{
        val topBest: MutableList<TopStudent> = mutableListOf()
        val topWorst: MutableList<TopStudent> = mutableListOf()
        groupA.forEach { student ->
            if (student.score > 90){
                topBest.add(
                    TopStudent(
                        name = student.name,
                        lastName = student.lastName,
                        score = student.score
                    ))

            }else if (student.score < 40){
                topWorst.add(
                    TopStudent(
                        name = student.name,
                        lastName = student.lastName,
                        score = student.score
                    ))
            }

        }
        return ListOfTopStudents(
            topBest = topBest,
            topWorst = topWorst
        )
    }

    fun getGroupB(): ListOfTopStudents{
        val topBest: MutableList<TopStudent> = mutableListOf()
        val topWorst: MutableList<TopStudent> = mutableListOf()
        groupB.forEach { student ->
            if (student.score > 90){
                topBest.add(
                    TopStudent(
                        name = student.name,
                        lastName = student.lastName,
                        score = student.score
                    ))

            }else if (student.score < 40){
                topWorst.add(
                    TopStudent(
                        name = student.name,
                        lastName = student.lastName,
                        score = student.score
                    ))
            }

        }
        return ListOfTopStudents(
            topBest = topBest,
            topWorst = topWorst
        )
    }

    fun getGroupC(): ListOfTopStudents{
        val topBest: MutableList<TopStudent> = mutableListOf()
        val topWorst: MutableList<TopStudent> = mutableListOf()
        groupC.forEach { student ->
            if (student.score > 90){
                topBest.add(
                    TopStudent(
                        name = student.name,
                        lastName = student.lastName,
                        score = student.score
                    ))

            }else if (student.score < 40){
                topWorst.add(
                    TopStudent(
                        name = student.name,
                        lastName = student.lastName,
                        score = student.score
                    ))
            }

        }
        return ListOfTopStudents(
            topBest = topBest,
            topWorst = topWorst
        )
    }



}