package com.vishal2376.todolist.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishal2376.todolist.data.repository.TodoRepository
import com.vishal2376.todolist.domain.model.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {
	var todo: Todo by mutableStateOf(
		Todo(
			0,
			"",
			false
		)
	)
		private set

	val getAllTodos = repository.getAllTodos()

	private var deletedTodo: Todo? = null

	fun insertTodo(todo: Todo) {
		viewModelScope.launch(Dispatchers.IO) {
			repository.insertTodo(todo)
		}
	}

	fun updateTodo(todo: Todo) {
		viewModelScope.launch(Dispatchers.IO) {
			repository.updateTodo(todo)
		}
	}

	fun delete(todo: Todo) {
		viewModelScope.launch(Dispatchers.IO) {
			repository.deleteTodo(todo)
		}
	}

	fun undoDeletedTodo() {
		deletedTodo?.let {
			viewModelScope.launch(Dispatchers.IO) {
				repository.insertTodo(it)
			}
		}
	}

	fun getTodoById(id: Int) {
		viewModelScope.launch(Dispatchers.IO) {
			todo = repository.getTodoById(id)
		}
	}

	fun updateTask(newTask: String) {
		todo = todo.copy(task = newTask)
	}

	fun updateIsImportant(newValue: Boolean) {
		todo = todo.copy(isImportant = newValue)
	}
}