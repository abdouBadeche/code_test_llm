package com.meformer.repository

import com.meformer.network.CourseApi

class CourseRepository(private val courseApi: CourseApi) {
    suspend fun getCourses() = courseApi.getCourses()

    suspend fun getCourseDetails(id: Int) = courseApi.getCourseDetails(id)
}