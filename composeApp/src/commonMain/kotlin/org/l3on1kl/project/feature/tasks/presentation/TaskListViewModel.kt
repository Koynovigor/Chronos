package org.l3on1kl.project.feature.tasks.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import org.l3on1kl.project.core.ui.model.Task
import org.l3on1kl.project.feature.tasks.data.TaskRepository

class TaskListViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks = repository.getAllTasks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    suspend fun insertTask(task: Task) {
        repository.insertTask(task)
    }
}
