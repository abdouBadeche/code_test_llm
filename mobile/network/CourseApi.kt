package com.meformer.network

import retrofit2.http.GET
import retrofit2.http.Path

data class CourseResponse(val id: Int, val title: String, val description: String, val duration: Int)

interface CourseApi {
    @GET("/courses")
    suspend fun getCourses(): List<CourseResponse>

    @GET("/courses/{id}")
    suspend fun getCourseDetails(@Path("id") id: Int): CourseResponse
}