package com.example.motivation.todo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var todoList: ArrayList<TodoItem> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initRecyclerView()
    }

    fun initRecyclerView() {

        var todoListAdapter = RecyclerViewAdapter(initTodoData())

        main_todolist.layoutManager = LinearLayoutManager(applicationContext)
        main_todolist.adapter = todoListAdapter

    }

    fun initTodoData(): ArrayList<TodoItem> {

        for (i in 1..5)
            todoList.add(TodoItem("Title$i", false))

        return todoList
    }
}
