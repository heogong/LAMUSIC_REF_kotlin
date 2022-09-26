package com.justdoit.lamusic_kotlin.attendance.handler

import com.justdoit.lamusic_kotlin.attendance.service.AttendanceService
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class AttendanceHandler(private val attendanceService: AttendanceService) {

    suspend fun createAttendanceHandler(req: ServerRequest): ServerResponse {
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .bodyAndAwait(attendanceService.createAttendance(req.awaitBodyOrNull()))
    }

    suspend fun getAttendanceHandler(req: ServerRequest): ServerResponse {
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .bodyValueAndAwait(attendanceService.getAttendance(
                        req.pathVariable("date"),
                        req.pathVariable("id")
                ))
    }

    suspend fun updateAttendanceHandler(req: ServerRequest): ServerResponse {
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .bodyAndAwait(attendanceService.updateAttendance(req.awaitBodyOrNull()))
    }
}