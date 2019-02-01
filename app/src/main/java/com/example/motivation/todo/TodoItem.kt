package com.example.motivation.todo

class TodoItem {

    var title = "Default"
    var checked = false

    constructor()

    constructor(_title: String, _isCheck: Boolean){
        title = _title
        checked = _isCheck
    }
}