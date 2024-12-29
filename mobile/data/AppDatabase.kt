package com.meformer.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class, CourseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun courseDao(): CourseDao
}