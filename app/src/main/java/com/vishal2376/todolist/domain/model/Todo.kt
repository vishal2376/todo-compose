package com.vishal2376.todolist.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,
	val task: String,
	val isImportant: Boolean
)
