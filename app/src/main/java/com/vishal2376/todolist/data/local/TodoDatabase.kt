package com.vishal2376.todolist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vishal2376.todolist.domain.model.Todo

@Database(
	entities = [Todo::class],
	version = 1,
	exportSchema = true
)
abstract class TodoDatabase : RoomDatabase() {
	abstract fun todoDao(): TodoDao
}