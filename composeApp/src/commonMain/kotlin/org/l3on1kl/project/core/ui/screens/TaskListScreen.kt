package org.l3on1kl.project.core.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.l3on1kl.project.core.ui.model.Task
import org.l3on1kl.project.core.utils.formatAsReadableString
import org.l3on1kl.project.feature.tasks.presentation.TaskListViewModel

@Composable
fun TaskListScreen(viewModel: TaskListViewModel) {
    val tasks by viewModel.tasks.collectAsState()

    LazyColumn {
        items(tasks) { TaskCard(it) }
    }
}


@Composable
fun TaskCard(task: Task) =
    Card(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(task.title, style = MaterialTheme.typography.titleMedium)
            Text(task.description, style = MaterialTheme.typography.bodyMedium)
            Text(task.due.formatAsReadableString(), style = MaterialTheme.typography.bodySmall)
        }
    }
