package com.example.todolist.utils

enum class Action {
    ADD, UPDATE, DELETE, DELETE_ALL, UNDO, NO_ACTION,IMPORT
}

fun String?.toAction(): Action {
    return when {
        this == "ADD" -> Action.ADD
        this == "UPDATE" -> Action.UPDATE
        this == "DELETE" -> Action.DELETE
        this == "DELETE_ALL" -> Action.DELETE_ALL
        this == "UNDO" -> Action.UNDO
        this =="IMPORT"-> Action.IMPORT
        else -> Action.NO_ACTION
    }
}