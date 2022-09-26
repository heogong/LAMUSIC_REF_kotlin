package com.justdoit.lamusic_kotlin.student.router

import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.coRouter

@Component
class StudentRouter(private val studentHandler: StudentHandler) {

    @Bean
    fun apiRouter() = coRouter {
        "/student".nest{
            accept(APPLICATION_JSON).nest {
                GET("/", studentHandler::getAllStudentHandler)
                POST("", studentHandler::createStudentHandler)
                "/{id}".nest {
                    PATCH("", studentHandler::updateStudentHandler)
                    GET("/", studentHandler::getStudentHandler)
                }
        }}
    }
}