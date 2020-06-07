package com.wechats.roomtodolist

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wechats.roomtodolist.db.AppDatabase
import com.wechats.roomtodolist.db.model.Todo
import kotlinx.android.synthetic.main.activity_update_todo.*
import kotlinx.android.synthetic.main.activity_update_todo.content_edit
import kotlinx.android.synthetic.main.activity_update_todo.name_edit


class UpdateTodoActivity : AppCompatActivity() {

    private lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_todo)

        appDatabase = AppDatabase.getInstance(this)!!
        val todo = intent.getParcelableExtra<Todo>("todo")
        bind(todo!!)

    }

    private fun bind (todo: Todo) {
        name_edit.setText(todo.name)
        content_edit.setText(todo.content)

        update_todo_button.setOnClickListener {
            AsyncTask.execute {
                val updateTodo = Todo(todo.id, name_edit.text.toString(), content_edit.text.toString())
                appDatabase.todoDao().update(updateTodo)
                finish()
            }
        }

        delete_todo_button.setOnClickListener {
            AsyncTask.execute {
                appDatabase.todoDao().delete(todo)
                finish()
            }
        }
    }

}
