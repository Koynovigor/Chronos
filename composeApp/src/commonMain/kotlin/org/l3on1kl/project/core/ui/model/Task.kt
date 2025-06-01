package org.l3on1kl.project.core.ui.model

import kotlinx.datetime.LocalDateTime


enum class TaskStatus { ACTIVE, IN_PROGRESS, DONE }

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val due: LocalDateTime,
    val status: TaskStatus
)
