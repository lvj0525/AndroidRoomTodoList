package com.wechats.roomtodolist

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wechats.roomtodolist.db.AppDatabase
import com.wechats.roomtodolist.db.model.Todo
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodoActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        database = AppDatabase.getInstance(this)!!

        add_todo_button.setOnClickListener {

            AsyncTask.execute {
                val todo = Todo(name = name_edit.text.toString(), content = content_edit.text.toString())
                database.todoDao().insert(todo)
                finish()
            }

        }
    }
}
