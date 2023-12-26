package com.vishal2376.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.vishal2376.todolist.presentation.MainViewModel
import com.vishal2376.todolist.presentation.navigation.AppNavigation
import com.vishal2376.todolist.ui.theme.TodoListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

	private val mainViewModel by viewModels<MainViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TodoListTheme {
				AppNavigation(mainViewModel = mainViewModel)
			}
		}
	}
}