package com.vishal2376.todolist.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.vishal2376.todolist.domain.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertTodo(todo: Todo)

	@Update(onConflict = OnConflictStrategy.REPLACE)
	suspend fun updateTodo(todo: Todo)

	@Delete
	suspend fun deleteTodo(todo: Todo)

	@Query("SELECT * FROM todo_table WHERE id=:id")
	suspend fun getTodoById(id: Int): Todo

	@Query("SELECT * FROM todo_table")
	fun getAllTodos(): Flow<List<Todo>>

}