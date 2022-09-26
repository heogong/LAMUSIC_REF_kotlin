package com.justdoit.lamusic_kotlin.student.dto

import com.justdoit.lamusic_kotlin.common.constant.RegistrationStatus
import com.justdoit.lamusic_kotlin.student.entity.Student
import java.util.*

class StudentDTO {

    data class StudentReq(
            var name: String? = null,
            var birthDay: String? = null,
            var gender: String? = null,
            var phone: String? = null,
            var address: String? = null,
            var description: String? = null,
            var status: RegistrationStatus,

            // 개인 레슨 정보
            var startLessonDate: String?= null,
            var endLessonDate: String?= null,
//            var classDates: Int,
//            var lessonTerm: Int,
//            var lessonWeek: Int,

            // 결제 정보
            var cashAmount: String?= null,
            var accountAmount: String?= null,
            var cardAmount: String?= null,
            var cardCompanyInfo: String?= null,
            var paymentMemo: String?= null,
            var accountDate: Date?= null,

            // 수업정보
            var lessonCourseReqs: List<StudentLessonCourseDTO.LessonCourseReq>
    )

    data class StudentResp(
            var name: String? = null,
            var birthDay: String? = null,
            var gender: String? = null,
            var phone: String? = null,
            var address: String? = null,
            var description: String? = null,
            var createDate: Date?,
            var updateDate: Date?
    ) {
        companion object {
            fun createStudentResp(student: Student): StudentResp {
                return student.run {
                    StudentResp(
                            name = name,
                            birthDay = birthday,
                            gender = gender,
                            phone = phone,
                            address = address,
                            description = description,
                            createDate = createDate,
                            updateDate = updateDate
                    )
                }
            }
        }
    }
}