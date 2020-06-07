package com.wechats.roomtodolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wechats.roomtodolist.adapter.OnTodoItemClickedListener
import com.wechats.roomtodolist.adapter.RecyclerAdapter
import com.wechats.roomtodolist.db.AppDatabase
import com.wechats.roomtodolist.db.model.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var appDatabase: AppDatabase? = null
    private lateinit var recyclerView: RecyclerView
    private val viewAdapter = RecyclerAdapter()
    private val viewManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        appDatabase = AppDatabase.getInstance(this)

        add_button.setOnClickListener {
            intent = Intent(this, AddTodoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        appDatabase!!.todoDao().getTodoList().observe(this, Observer {
            viewAdapter.todos = it
            viewAdapter.notifyDataSetChanged()
        })
    }

    private fun initRecycler() {
        recyclerView = recycle_view.apply {
            setHasFixedSize(true)
            adapter = viewAdapter
            layoutManager = viewManager
        }

        viewAdapter.setTodoItemClickedListener(object : OnTodoItemClickedListener {
            override fun onTodoItemClicked(todo: Todo) {
                val intent = Intent(this@MainActivity, UpdateTodoActivity::class.java)
                intent.putExtra("todo", todo)
                startActivity(intent)
            }

        })
    }
}
