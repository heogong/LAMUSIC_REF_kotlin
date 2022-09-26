package com.justdoit.lamusic_kotlin.student.entity

import com.justdoit.lamusic_kotlin.student.dto.StudentDTO

class StudentLesson(
        // 수강 시작일
        var startLessonDate: String?= null,

        // 수강 종료일
        var endLessonDate: String?= null,

        // 수강 기간
//        var classDates: Int,
//        var lessonTerm: Int,
//        var lessonWeek: Int,
) {

    companion object{
        fun createStudentLesson(req: StudentDTO.StudentReq): StudentLesson {
            return req.run {
                StudentLesson(
                        startLessonDate = startLessonDate,
                        endLessonDate = endLessonDate,
//                        classDates = classDates,
//                        lessonTerm = lessonTerm,
//                        lessonWeek = lessonWeek
                )
            }
        }
    }
}