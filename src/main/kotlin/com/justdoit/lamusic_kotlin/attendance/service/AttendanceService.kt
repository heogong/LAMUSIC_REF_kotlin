package com.justdoit.lamusic_kotlin.attendance.service

import com.justdoit.lamusic_kotlin.attendance.dto.AttendanceDTO
import com.justdoit.lamusic_kotlin.attendance.entity.Attendance
import com.justdoit.lamusic_kotlin.attendance.repository.AttendanceRepository
import com.justdoit.lamusic_kotlin.student.service.StudentService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class AttendanceService(
        private val attendanceRepository: AttendanceRepository,
        private val studentService: StudentService) {

    private val log = LoggerFactory.getLogger(javaClass)

    suspend fun createAttendance(req: AttendanceDTO.AttendanceReq?): Flow<AttendanceDTO.AttendanceResp> =
            attendanceRepository.saveAll(req!!.attendanceType.map { Attendance.createAttendance(req, it) })
                    .map { AttendanceDTO.AttendanceResp.createAttendanceResp(it) }

    suspend fun getAttendance(date: String, id: String): AttendanceDTO.AttendanceStudentStatusResp {

        val attendanceList = CoroutineScope(Dispatchers.IO).async {
            log.info("attendanceList scope")
//            Thread.sleep(1000L)
            attendanceRepository.findByAttendanceDateAndStudentId(date, id)
                    .filter { it.validAttendance() }.toList()
        }

        val student = CoroutineScope(Dispatchers.IO).async {
            log.info("student scope")
//            Thread.sleep(1000L)
            studentService.getStudent(id)
        }

        return AttendanceDTO.AttendanceStudentStatusResp.createAttendanceStudentStatusResp(
                attendanceList.await(), student.await())
    }

    suspend fun updateAttendance(req: AttendanceDTO.AttendanceReq?): Flow<AttendanceDTO.AttendanceResp> {

        // λΉνμ±ν
        return attendanceRepository.findAllById(req!!.deleteAttendance)
                .map { attendanceRepository.save(it.updateUnValidAttendance()) }
                .map { AttendanceDTO.AttendanceResp.createAttendanceResp(it) }
    }
}