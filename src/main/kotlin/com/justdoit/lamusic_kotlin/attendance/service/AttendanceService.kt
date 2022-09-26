package com.justdoit.lamusic_kotlin.attendance.service

import com.justdoit.lamusic_kotlin.attendance.dto.AttendanceDTO
import com.justdoit.lamusic_kotlin.attendance.entity.Attendance
import com.justdoit.lamusic_kotlin.attendance.repository.AttendanceRepository
import com.justdoit.lamusic_kotlin.student.service.StudentService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class AttendanceService(
        private val attendanceRepository: AttendanceRepository,
        private val studentService: StudentService)
{

    suspend fun createAttendance(req: AttendanceDTO.AttendanceReq?): Flow<AttendanceDTO.AttendanceResp> {
        return attendanceRepository.saveAll(req!!.attendanceType.map { Attendance.createAttendance(req, it) })
                .map { AttendanceDTO.AttendanceResp.createAttendanceResp(it) }
    }

    suspend fun getAttendance(date: String, id: String): AttendanceDTO.AttendanceStudentStatusResp {
        val attendance = attendanceRepository.findByAttendanceDateAndStudentId(date, id)
                .filter { it.validAttendance() }.toList()
        val student = studentService.getStudent(id)
        return AttendanceDTO.AttendanceStudentStatusResp.createAttendanceStudentStatusResp(attendance, student)
    }

    suspend fun updateAttendance(req: AttendanceDTO.AttendanceReq?): Flow<AttendanceDTO.AttendanceResp> {

        // 비활성화
        return attendanceRepository.findAllById(req!!.deleteAttendance)
                .map { attendanceRepository.save(it.updateUnValidAttendance()) }
                .map { AttendanceDTO.AttendanceResp.createAttendanceResp(it) }
    }
}