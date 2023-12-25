package com.vishal2376.todolist.di

import android.content.Context
import androidx.room.Room
import com.vishal2376.todolist.data.local.TodoDao
import com.vishal2376.todolist.data.local.TodoDatabase
import com.vishal2376.todolist.data.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun provideLocalDatabase(@ApplicationContext context: Context): TodoDatabase {
		return Room.databaseBuilder(
			context,
			TodoDatabase::class.java,
			"local_db"
		).build()
	}

	@Provides
	@Singleton
	fun provideTodoDao(db: TodoDatabase): TodoDao {
		return db.todoDao()
	}

	@Provides
	@Singleton
	fun provideTodoRepository(dao: TodoDao): TodoRepository {
		return TodoRepository(dao)
	}

}