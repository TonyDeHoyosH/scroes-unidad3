package com.antonioselvas.scores_u3.viewmodel


import androidx.lifecycle.ViewModel
import com.antonioselvas.scores_u3.models.Group
import com.antonioselvas.scores_u3.models.Groups
import com.antonioselvas.scores_u3.models.ListOfTopStudents
import com.antonioselvas.scores_u3.models.Student
import com.antonioselvas.scores_u3.models.TopStudent


class StudentViewModel : ViewModel(){

    private var _groupA: MutableList<Student> = mutableListOf()
    val groupA: MutableList<Student> = _groupA

    private var _groupB: MutableList<Student> = mutableListOf()
    val groupB: MutableList<Student> = _groupB

    private var _groupC: MutableList<Student> = mutableListOf()
    val groupC: MutableList<Student> = _groupC

    fun getUniqueGrades(): List<Int> {
        val allStudents = groupA + groupB + groupC
        return allStudents.map { it.grade }.distinct().sorted()
    }

    fun getGroupsByGrade(grade: Int): Groups {
        return Groups(
            groupA = Group(
                group = "A",
                numberStudents = groupA.filter { it.grade == grade }.size,
                listOfStudents = groupA.filter { it.grade == grade }
            ),
            groupB = Group(
                group = "B",
                numberStudents = groupB.filter { it.grade == grade }.size,
                listOfStudents = groupB.filter { it.grade == grade }
            ),
            groupC = Group(
                group = "C",
                numberStudents = groupC.filter { it.grade == grade }.size,
                listOfStudents = groupC.filter { it.grade == grade }
            )
        )
    }

    fun getAverageByGradeAndGroup(grade: Int, group: String): Float {
        val students = when(group) {
            "A" -> groupA.filter { it.grade == grade }
            "B" -> groupB.filter { it.grade == grade }
            "C" -> groupC.filter { it.grade == grade }
            else -> emptyList()
        }
        return if (students.isEmpty()) 0f else students.map { it.score }.average().toFloat()
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

    fun getGroupA(): ListOfTopStudents {
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