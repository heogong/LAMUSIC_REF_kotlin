package com.justdoit.lamusic_kotlin.student.dto

class StudentLessonCourseDTO {
    data class LessonCourseReq(
            var lessonClassName: String?= null,
            var courseTypeName: String?= null,
            var lessonDay: String?= null,
            var lessonHour: String?= null,
            var lessonMin: String?= null,
            var lessonDuration: String?= null
    )
}