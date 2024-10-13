package com.example.todolistmvp

class TaskPresenter(private val view: TaskView, private val model: TaskModel) {
    fun addTask(task: Task) {
        model.addTask(task)
        view.showTaskAddedSuccess()
        view.displayTasks(model.getTasks())
    }

    fun deleteTask(task: Task) {
        model.deleteTask(task)
        view.showTaskDeletedSuccess()
        view.displayTasks(model.getTasks())
    }
}
