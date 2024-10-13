package com.example.todolistmvp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolistmvp.Task
import com.example.todolistmvp.TaskPresenter

@Composable
fun TaskListScreen(navController: NavController, presenter: TaskPresenter, tasks: List<Task>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        tasks.forEach { task ->
            TaskItem(task = task, onDeleteClick = { presenter.deleteTask(task) })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("taskForm") }) {
            Text(text = "Adicionar Tarefa")
        }
    }
}

@Composable
fun TaskItem(task: Task, onDeleteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = task.title)

            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Excluir Tarefa",
                    tint = Color.Red
                )
            }
        }
    }
}
