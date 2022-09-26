package com.justdoit.lamusic_kotlin.student.entity

import com.justdoit.lamusic_kotlin.student.dto.StudentDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
class Student (
        @Id
        var id: String?= null,
        var name: String?= null,
        var birthday: String?= null,
        var gender: String? = null,
        var phone: String? = null,
        var address: String? = null,
        var description: String? = null,
        var createDate: Date? = null,
        var updateDate: Date? = null
) {
        fun updateStudent(req: StudentDTO.StudentReq): Student {
                this.name = req.name
                this.birthday = req.birthDay
                this.gender = req.gender
                this.phone = req.phone
                this.address = req.address
                this.description = req.description
                this.updateDate = Date()
                return this
        }

        companion object{
                fun createStudent(req: StudentDTO.StudentReq): Student {
                        return req.run {
                                Student(
                                        name = name,
                                        birthday = birthDay,
                                        gender = gender,
                                        phone = phone,
                                        address = address,
                                        description = description,
                                        createDate = Date(),
                                        updateDate = Date()
                                )
                        }
                }

        }


}
