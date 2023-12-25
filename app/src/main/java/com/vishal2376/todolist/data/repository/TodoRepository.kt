package com.vishal2376.todolist.data.repository

import com.vishal2376.todolist.data.local.TodoDao
import com.vishal2376.todolist.domain.model.Todo
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val dao: TodoDao) {

	suspend fun insertTodo(todo: Todo) {
		dao.insertTodo(todo)
	}

	suspend fun updateTodo(todo: Todo) {
		dao.updateTodo(todo)
	}

	suspend fun deleteTodo(todo: Todo) {
		dao.deleteTodo(todo)
	}

	suspend fun getTodoById(id: Int): Todo {
		return dao.getTodoById(id)
	}

	fun getAllTodos(): Flow<List<Todo>> {
		return dao.getAllTodos()
	}

}