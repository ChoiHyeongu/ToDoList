package com.example.motivation.todo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, "todo.db", null, VERSION){

    companion object {
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table  if not exists todolist(" +
                "title varchar(100) not null" +
                ");"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}