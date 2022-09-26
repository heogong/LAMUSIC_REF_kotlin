package com.justdoit.lamusic_kotlin.student.service

import com.justdoit.lamusic_kotlin.student.dto.StudentDTO
import com.justdoit.lamusic_kotlin.student.entity.Student
import com.justdoit.lamusic_kotlin.student.repository.StudentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {

    suspend fun getStudent(id : String) : StudentDTO.StudentResp {
        return StudentDTO.StudentResp.createStudentResp(studentRepository.findById(id)!!)
    }

    suspend fun createStudent(studentReq: StudentDTO.StudentReq?): StudentDTO.StudentResp {
        val student = studentRepository.save(Student.createStudent(studentReq!!))
        return StudentDTO.StudentResp.createStudentResp(student)
    }

    suspend fun updateStudent(id: String, studentReq: StudentDTO.StudentReq?): StudentDTO.StudentResp {
        val student = studentRepository.findById(id)!!.updateStudent(studentReq!!)
        return StudentDTO.StudentResp.createStudentResp(studentRepository.save(student))
    }

    suspend fun getAllStudent(): Flow<StudentDTO.StudentResp> {
        return studentRepository.findAll()
                .map { StudentDTO.StudentResp.createStudentResp(it)}
    }
}