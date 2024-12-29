package com.meformer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meformer.repository.CourseRepository
import kotlinx.coroutines.launch

class CourseViewModel(private val courseRepository: CourseRepository) : ViewModel() {
    var courses: List<CourseResponse> = emptyList()
        private set

    fun fetchCourses(onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                courses = courseRepository.getCourses()
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "An error occurred")
            }
        }
    }

    fun fetchCourseDetails(id: Int, onSuccess: (CourseResponse) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val course = courseRepository.getCourseDetails(id)
                onSuccess(course)
            } catch (e: Exception) {
                onError(e.message ?: "An error occurred")
            }
        }
    }
}