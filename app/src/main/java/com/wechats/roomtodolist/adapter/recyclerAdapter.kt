package com.wechats.roomtodolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wechats.roomtodolist.R
import com.wechats.roomtodolist.db.model.Todo
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var onTodoItemClickedListener : OnTodoItemClickedListener
    var todos: List<Todo> = mutableListOf()

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        private val name = view.name_text
        private val content = view.content_text
        fun bind (todo: Todo) {
            name.text = todo.name
            content.text = todo.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = todos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = todos[position]
        holder.bind(todo)
        holder.view.setOnClickListener {
            onTodoItemClickedListener.onTodoItemClicked(todo)
        }
    }

    fun setTodoItemClickedListener(onTodoItemClickedListener: OnTodoItemClickedListener){
        this.onTodoItemClickedListener = onTodoItemClickedListener
    }

}