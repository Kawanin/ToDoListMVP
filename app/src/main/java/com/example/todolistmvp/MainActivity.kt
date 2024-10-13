package com.example.todolistmvp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistmvp.ui.TaskListScreen
import com.example.todolistmvp.ui.TaskFormScreen

class MainActivity : ComponentActivity(), TaskView {
    private lateinit var presenter: TaskPresenter
    private var tasks by mutableStateOf(emptyList<Task>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "taskList") {
                composable("taskList") {
                    TaskListScreen(navController, presenter, tasks)
                }
                composable("taskForm") {
                    TaskFormScreen(navController, presenter)
                }
            }
        }
        presenter = TaskPresenter(this, TaskModel())
    }

    override fun showTaskAddedSuccess() {
        Toast.makeText(this, "Tarefa adicionada com sucesso!", Toast.LENGTH_SHORT).show()
    }

    override fun showTaskDeletedSuccess() {
        Toast.makeText(this, "Tarefa deletada com sucesso!", Toast.LENGTH_SHORT).show()
    }

    override fun displayTasks(tasks: List<Task>) {
        this.tasks = tasks
    }
}
