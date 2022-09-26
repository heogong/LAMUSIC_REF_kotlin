package com.justdoit.lamusic_kotlin.student.controller

import com.justdoit.lamusic_kotlin.student.dto.StudentDTO
import com.justdoit.lamusic_kotlin.student.entity.Student
import com.justdoit.lamusic_kotlin.student.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class StudentController(private val studentService: StudentService) {
//
    @GetMapping("/student/{id}")
    suspend fun getStudent(@PathVariable id: String) =
            ResponseEntity(studentService.getStudent(id), HttpStatus.OK)
//
//    @PostMapping("/student")
//    suspend fun createStudent(@RequestBody studentReq : Mono<StudentDTO.StudentReq>) =
//            ResponseEntity(studentService.createStudent(studentReq), HttpStatus.OK)
//
//    @PatchMapping("/student/{id}")
//    fun updateStudent(@PathVariable id: String, @RequestBody studentReq: Mono<StudentDTO.StudentReq>) =
//            ResponseEntity(studentService.updateStudent(id, studentReq), HttpStatus.OK)

//    @GetMapping("/student")
//    suspend fun getAllStudent() =
//            ResponseEntity(studentService.getAllStudent(), HttpStatus.OK)
}