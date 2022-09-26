package com.justdoit.lamusic_kotlin.student.handler

import com.justdoit.lamusic_kotlin.student.service.StudentService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class StudentHandler(private val studentService: StudentService) {

    suspend fun getStudentHandler(req: ServerRequest): ServerResponse {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .bodyValueAndAwait(studentService.getStudent(req.pathVariable("id")))
    }

    suspend fun getAllStudentHandler(req: ServerRequest): ServerResponse {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .bodyAndAwait(studentService.getAllStudent())
    }

    suspend fun createStudentHandler(req: ServerRequest): ServerResponse {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .bodyValueAndAwait(studentService.createStudent(req.awaitBodyOrNull()))
    }

    suspend fun updateStudentHandler(req: ServerRequest): ServerResponse {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .bodyValueAndAwait(studentService.updateStudent(
                        req.pathVariable("id"),
                        req.awaitBodyOrNull())
                )
    }
}