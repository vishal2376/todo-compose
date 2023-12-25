package com.vishal2376.todolist.presentation.common

import android.content.Context
import android.widget.Toast

fun toastMsg(
	context: Context,
	message: String
) {
	Toast.makeText(
		context,
		message,
		Toast.LENGTH_SHORT
	).show()
}