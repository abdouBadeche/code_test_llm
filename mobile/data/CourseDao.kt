package com.meformer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CourseDao {
    @Insert
    suspend fun insertCourse(course: CourseEntity)

    @Query("SELECT * FROM courses")
    suspend fun getAllCourses(): List<CourseEntity>
}