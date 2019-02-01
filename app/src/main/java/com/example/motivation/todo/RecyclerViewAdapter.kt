package com.example.motivation.todo

import android.app.AlertDialog
import android.app.Dialog
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class RecyclerViewAdapter(list: ArrayList<TodoItem>) : RecyclerView.Adapter<CustomViewHolder>() {

    private var todoList: ArrayList<TodoItem> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_recycler_view, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.item_title.text = todoList.get(position).title
        holder.itemView.item_title.setChecked(todoList.get(position).checked)
        holder.itemView.item_delete.setOnClickListener {
            if (todoList.size >= 1) {
                todoList.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }
}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

}

