package com.justdoit.lamusic_kotlin.student.entity

import com.justdoit.lamusic_kotlin.student.dto.StudentLessonCourseDTO

class StudentLessonCourse(
        var lessonClassName: String?= null, // 선생님 이름으로 class(반) 이 나뉨
        var courseTypeName: String?= null, // 배울 악기
        var lessonDay: String?= null, // 수업요일
        // 수업시간
        var lessonHour: String?= null,
        var lessonMin: String?= null,
        var lessonDuration: String?= null // 수업기간(시간)
) {
    companion object{
        fun createStudentLessonCourse(req: StudentLessonCourseDTO.LessonCourseReq): StudentLessonCourse {
            return req.run {
                StudentLessonCourse(
                        lessonClassName = lessonClassName,
                        courseTypeName = courseTypeName,
                        lessonDay = lessonDay,
                        lessonHour = lessonHour,
                        lessonMin = lessonMin,
                        lessonDuration = lessonDuration
                )
            }
        }
    }
}