package com.wechats.roomtodolist.adapter

import com.wechats.roomtodolist.db.model.Todo

interface OnTodoItemClickedListener {
    fun onTodoItemClicked(todo: Todo)
}