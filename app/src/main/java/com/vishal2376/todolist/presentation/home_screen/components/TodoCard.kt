package com.vishal2376.todolist.presentation.home_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal2376.todolist.domain.model.Todo
import com.vishal2376.todolist.presentation.common.taskTextStyle

@Composable
fun TodoCard(
	todo: Todo,
	onDone: () -> Unit,
	onUpdate: (id: Int) -> Unit
) {
	Card(modifier = Modifier.fillMaxWidth()) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(
					8.dp, 4.dp
				), verticalAlignment = Alignment.CenterVertically
		) {
			IconButton(modifier = Modifier.weight(1f), onClick = { onDone() }) {
				Icon(
					imageVector = Icons.Rounded.Check, contentDescription = null
				)
			}

			Text(
				text = todo.task,
				maxLines = 2,
				overflow = TextOverflow.Ellipsis,
				modifier = Modifier.weight(8f),
				style = taskTextStyle
			)

			if (todo.isImportant) {
				Icon(
					imageVector = Icons.Rounded.Star, contentDescription = null, Modifier.weight(1f)
				)
			}

			IconButton(modifier = Modifier.weight(1f), onClick = { onUpdate(todo.id) }) {
				Icon(
					imageVector = Icons.Rounded.Edit, contentDescription = null
				)
			}

		}
	}
}

@Preview
@Composable
private fun TodoCardPreview() {
	val todo = Todo(
		0, "Task Sample", true
	)

	TodoCard(todo, {}, {})
}