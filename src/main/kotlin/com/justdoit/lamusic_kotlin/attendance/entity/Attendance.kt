package com.justdoit.lamusic_kotlin.attendance.entity

import com.justdoit.lamusic_kotlin.attendance.dto.AttendanceDTO
import com.justdoit.lamusic_kotlin.common.constant.AttendanceType
import com.justdoit.lamusic_kotlin.common.constant.Valid
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class Attendance(
        @Id
        var id: String?= null,
        var attendanceDate: String, // YYYYMMDD
        var attendanceType: AttendanceType,
        var attendanceMemo: String?= null,
        var studentId: String,
        var valid: Valid,
        var createDate: Date,
        var updateDate: Date,
) {

    fun validAttendance(): Boolean {
        return this.valid == Valid.Y
    }

    fun updateUnValidAttendance(): Attendance {
        this.valid = Valid.N
        return this
    }

    companion object{
        fun createAttendance(req: AttendanceDTO.AttendanceReq, attendanceType: AttendanceType): Attendance {
            return req.run {
                Attendance(
                        attendanceDate = attendanceDate,
                        attendanceType = attendanceType,
                        attendanceMemo = attendanceMemo,
                        studentId = studentId,
                        valid = Valid.Y,
                        createDate = Date(),
                        updateDate = Date()
                )
            }
        }
    }

}