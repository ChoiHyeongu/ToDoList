package com.example.motivation.todo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class RecyclerViewAdapter(list: ArrayList<ToDo>) : RecyclerView.Adapter<CustomViewHolder>() {

    private var todoList : ArrayList<ToDo> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_recycler_view, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.item_title.text = "Title"
    }
}

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {

}

