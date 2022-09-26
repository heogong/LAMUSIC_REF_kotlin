package com.justdoit.lamusic_kotlin.student.entity

import com.justdoit.lamusic_kotlin.common.constant.ProcessClassType
import com.justdoit.lamusic_kotlin.common.constant.RegistrationStatus
import com.justdoit.lamusic_kotlin.common.constant.Valid
import com.justdoit.lamusic_kotlin.student.dto.StudentDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import kotlin.streams.toList

@Document
class Student (
        @Id
        var id: String?= null,
        var name: String?= null,
        var birthday: String?= null,
        var gender: String?= null,
        var phone: String?= null,
        var address: String?= null,
        var description: String?= null,
        var createDate: Date?= null,
        var updateDate: Date?= null,
        var status: RegistrationStatus,
        var valid: Valid,
        var job: String?= null,
        var processClassType: ProcessClassType?= null,
        var parentName: String? = null,
        var parentPhone: String? = null,
        var studentLesson: StudentLesson,
        var studentPayment: StudentPayment,
        var lessonCourses: List<StudentLessonCourse>

) {
        fun updateStudent(req: StudentDTO.StudentReq): Student {
                this.name = req.name
                this.birthday = req.birthDay
                this.gender = req.gender
                this.phone = req.phone
                this.address = req.address
                this.description = req.description
                this.status = req.status
                this.studentLesson = StudentLesson.createStudentLesson(req)
                this.studentPayment = StudentPayment.createStudentPayment(req)
                this.lessonCourses = req.lessonCourseReqs.stream()
                        .map { StudentLessonCourse.createStudentLessonCourse(it) }
                        .toList()
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
                                        studentLesson = StudentLesson.createStudentLesson(this),
                                        studentPayment = StudentPayment.createStudentPayment(this),
                                        lessonCourses = lessonCourseReqs.stream()
                                                .map { StudentLessonCourse.createStudentLessonCourse(it) }
                                                .toList(),
                                        status = RegistrationStatus.REG_LESSON,
                                        valid = Valid.Y,
                                        createDate = Date(),
                                        updateDate = Date()
                                )
                        }
                }

        }


}
