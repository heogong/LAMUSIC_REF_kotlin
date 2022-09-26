package com.justdoit.lamusic_kotlin.attendance.dto

import com.justdoit.lamusic_kotlin.attendance.entity.Attendance
import com.justdoit.lamusic_kotlin.common.constant.AttendanceType
import com.justdoit.lamusic_kotlin.student.dto.StudentDTO

class AttendanceDTO {
    data class AttendanceReq(
            var attendanceDate: String,
            var studentId: String,
            var attendanceMemo: String?= null,
            var attendanceType: List<AttendanceType>,
            var deleteAttendance: List<String>
    )

    data class AttendanceResp(
            var id: String?= null,
            var attendanceDate: String, // YYYYMMDD
            var attendanceType: AttendanceType,
            var attendanceMemo: String?= null
    ){
        companion object{
            fun createAttendanceResp(attendance: Attendance): AttendanceResp {
                return attendance.run {
                    AttendanceResp(
                            id = id,
                            attendanceDate = attendanceDate,
                            attendanceType = attendanceType,
                            attendanceMemo = attendanceMemo
                    )
                }
            }
        }
    }

    data class AttendanceStudentStatusResp(
            var studentId: String?= null,
            var studentName: String?= null,
//          var attendanceCount: Int,
            var startLessonDate: String?= null,
            var attendanceDate: String,
            var attendanceResp: List<AttendanceResp>
    ) {
        companion object{
            fun createAttendanceStudentStatusResp(
                    attendance: List<Attendance>,
                    student: StudentDTO.StudentResp
            ): AttendanceStudentStatusResp {
                return AttendanceStudentStatusResp(
                        studentId = "",
                        studentName = student.name,
//                        startLessonDate = student.
                        attendanceDate = "",
                        attendanceResp = attendance.map { AttendanceResp.createAttendanceResp(it) }
                )
            }
        }
    }
}