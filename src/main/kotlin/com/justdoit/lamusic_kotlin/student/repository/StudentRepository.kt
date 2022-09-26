package com.justdoit.lamusic_kotlin.student.repository

import com.justdoit.lamusic_kotlin.student.entity.Student
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CoroutineCrudRepository<Student, String>{
}