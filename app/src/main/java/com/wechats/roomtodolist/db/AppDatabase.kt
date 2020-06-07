package com.wechats.roomtodolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wechats.roomtodolist.db.dao.TodoDao
import com.wechats.roomtodolist.db.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase?{
            if (appDatabase == null){
                appDatabase = Room.databaseBuilder(context,
                    AppDatabase::class.java,
                    "todo-list-db")
                    .build()
            }
            return appDatabase
        }
    }
}