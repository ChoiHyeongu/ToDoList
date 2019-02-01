package com.example.motivation.todo

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.Log.d
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var todoList: ArrayList<TodoItem> = arrayListOf()
    var todoListAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            showAddListDialog()
        }

        initRecyclerView()
    }

    fun initRecyclerView() {

        todoListAdapter = RecyclerViewAdapter(initTodoData())

        main_todolist.layoutManager = LinearLayoutManager(applicationContext)
        main_todolist.adapter = todoListAdapter
    }

    fun initTodoData(): ArrayList<TodoItem> {

        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("select * from todolist", null)

        val count = cursor.count
        if(count >= 1) {
            while (cursor.moveToNext()) {
                val title = cursor.getString(0)
                todoList.add(TodoItem(title, false))
            }
        }
        cursor.close()

        return todoList
    }

    fun showAddListDialog() {

        val db = DBHelper(this).writableDatabase
        val titleEdit: EditText = EditText(this)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("할 일 추가")
        builder.setMessage("할 일을 적으세요.")
        builder.setView(titleEdit)
        builder.setPositiveButton("확인") { _, _ ->
            db.execSQL("insert into todolist values (\'${titleEdit.text}\')");
            Toast.makeText(this, "Todo 생성 완료", Toast.LENGTH_LONG).show()
            todoListAdapter!!.notifyItemInserted(todoList.size)
            todoListAdapter!!.notifyDataSetChanged()
        }
        builder.setNegativeButton("취소") { _, _ -> }
        builder.show()
    }
}
