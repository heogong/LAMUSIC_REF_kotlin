package com.justdoit.lamusic_kotlin.student.dto

import com.justdoit.lamusic_kotlin.student.entity.Student
import kotlinx.coroutines.flow.flow
import org.springframework.web.reactive.function.server.ServerResponse
import java.util.Date
import java.util.concurrent.Flow

class StudentDTO {

    data class StudentReq(
            var name: String? = null,
            var birthDay: String? = null,
            var gender: String? = null,
            var phone: String? = null,
            var address: String? = null,
            var description: String? = null
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