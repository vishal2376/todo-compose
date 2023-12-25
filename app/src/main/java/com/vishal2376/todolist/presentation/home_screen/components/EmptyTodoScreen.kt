package com.vishal2376.todolist.presentation.home_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun EmptyTodoScreen() {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = "No Tasks",
			fontSize = 28.sp
		)
	}
}