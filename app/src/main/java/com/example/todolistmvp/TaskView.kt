package com.example.todolistmvp

interface TaskView {
    fun showTaskAddedSuccess()
    fun showTaskDeletedSuccess()
    fun displayTasks(tasks: List<Task>)
}
