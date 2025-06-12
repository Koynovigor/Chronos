package org.l3on1kl.project.feature.tasks.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDateTime
import org.l3on1kl.project.core.db.ChronosDatabase
import org.l3on1kl.project.core.ui.model.Task
import org.l3on1kl.project.core.ui.model.TaskStatus
import org.l3on1kl.project.core.utils.DatabaseDispatcher

class TaskRepositoryImpl(
    private val db: ChronosDatabase
) : TaskRepository {

    override fun getAllTasks(): Flow<List<Task>> {
        return db.taskEntityQueries.selectAllTasks()
            .asFlow()
            .mapToList(DatabaseDispatcher)
            .map { list ->
                list.map { entity ->
                    Task(
                        id = entity.id.toLong(),
                        title = entity.title,
                        description = entity.description ?: "",
                        due = LocalDateTime.parse(entity.due),
                        status = TaskStatus.valueOf(entity.status)
                    )
                }
            }
    }

    override suspend fun insertTask(task: Task) {
        db.taskEntityQueries.insertTask(
            id = task.id.toString(),
            title = task.title,
            description = task.description,
            due = task.due.toString(),
            status = task.status.name
        )
    }

    override suspend fun deleteTask(taskId: String) {
        db.taskEntityQueries.deleteTask(taskId)
    }
}

