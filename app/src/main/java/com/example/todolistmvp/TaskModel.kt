package com.example.todolistmvp

class TaskModel {
    private val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun deleteTask(task: Task) {
        tasks.remove(task)
    }

    fun getTasks(): List<Task> {
        return tasks
    }
}
