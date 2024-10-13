package com.example.todolistmvp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todolistmvp.Task
import com.example.todolistmvp.TaskPresenter

@Composable
fun TaskFormScreen(navController: NavController, presenter: TaskPresenter) {
    val taskTitle = remember { mutableStateOf("") }
    val taskDescription = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD8E2DC))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = taskTitle.value,
            onValueChange = { taskTitle.value = it },
            label = { Text("Título da Tarefa") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = taskDescription.value,
            onValueChange = { taskDescription.value = it },
            label = { Text("Descrição da Tarefa") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val newTask = Task(
                    title = taskTitle.value,
                    description = taskDescription.value
                )
                presenter.addTask(newTask)
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(text = "Adicionar Tarefa")
        }
    }
}
