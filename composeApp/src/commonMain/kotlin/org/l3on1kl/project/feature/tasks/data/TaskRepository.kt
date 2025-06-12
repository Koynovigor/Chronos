package org.l3on1kl.project.feature.tasks.data

import kotlinx.coroutines.flow.Flow
import org.l3on1kl.project.core.ui.model.Task

interface TaskRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun deleteTask(taskId: String)
}
