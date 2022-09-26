package com.justdoit.lamusic_kotlin.router

import com.justdoit.lamusic_kotlin.attendance.handler.AttendanceHandler
import com.justdoit.lamusic_kotlin.student.handler.StudentHandler
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.coRouter

@Component
class Router(
        private val studentHandler: StudentHandler,
        private val attendanceHandler: AttendanceHandler) {
    @Bean
    fun apiRouter() = coRouter {
        "/student".nest{
            accept(APPLICATION_JSON).nest {
                GET("", studentHandler::getAllStudentHandler)
                POST("", studentHandler::createStudentHandler)
                "/{id}".nest {
                    PATCH("", studentHandler::updateStudentHandler)
                    GET("", studentHandler::getStudentHandler)
                }
        }}
        "/attendance".nest{
            accept(APPLICATION_JSON).nest {
                POST("", attendanceHandler::createAttendanceHandler)
                PATCH("", attendanceHandler::updateAttendanceHandler)
                GET("/date/{date}/student/{id}", attendanceHandler::getAttendanceHandler )
            }
        }
    }
}