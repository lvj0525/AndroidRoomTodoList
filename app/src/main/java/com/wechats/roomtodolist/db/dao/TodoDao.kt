package com.wechats.roomtodolist.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wechats.roomtodolist.db.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getTodoList(): LiveData<List<Todo>>

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}