package org.l3on1kl.project.core.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.l3on1kl.project.core.ui.model.Task
import org.l3on1kl.project.core.ui.model.TaskStatus
import org.l3on1kl.project.feature.tasks.presentation.TaskListViewModel


class CreateTaskScreen(
    val onTaskSaved: () -> Unit,
    val viewModel: TaskListViewModel
) : Screen {

    @Composable
    override fun Content() {
        CreateTaskScreenContent(
            onTaskSaved,
            viewModel
        )
    }
}

@Composable
fun CreateTaskScreenContent(
    onTaskSaved: () -> Unit,
    viewModel: TaskListViewModel
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    Column(Modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Название задачи") }
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Описание") }
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            viewModel.viewModelScope.launch {
                viewModel.insertTask(
                    Task(
                        id = Clock.System.now().toEpochMilliseconds(),
                        title = title,
                        description = description,
                        due = now,
                        status = TaskStatus.ACTIVE
                    )
                )
                onTaskSaved()
            }
        }) {
            Text("Сохранить")
        }
    }
}
