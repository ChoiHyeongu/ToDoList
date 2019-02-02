package com.example.motivation.todo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class RecyclerViewAdapter(list: ArrayList<TodoItem>, _context: Context) : RecyclerView.Adapter<CustomViewHolder>() {

    private var todoList: ArrayList<TodoItem> = list
    private val context = _context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_recycler_view, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val db = DBHelper(context).writableDatabase
        holder.itemView.item_title.text = todoList.get(position).title
        holder.itemView.item_title.setChecked(todoList.get(position).checked)
        holder.itemView.item_delete.setOnClickListener {
            db.execSQL("DELETE FROM todolist WHERE title = ('${todoList[position].title}')")
            todoList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, todoList.size)
        }
    }
}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {
}

