package com.justdoit.lamusic_kotlin.attendance.repository

import com.justdoit.lamusic_kotlin.attendance.entity.Attendance
import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendanceRepository : CoroutineCrudRepository<Attendance, String> {
    fun findByAttendanceDateAndStudentId(toDate: String, studentId: String): Flow<Attendance>
}