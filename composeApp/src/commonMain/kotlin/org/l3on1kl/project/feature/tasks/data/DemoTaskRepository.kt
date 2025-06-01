package org.l3on1kl.project.feature.tasks.data

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import org.l3on1kl.project.core.ui.model.Task
import org.l3on1kl.project.core.ui.model.TaskStatus

object DemoTaskRepository {
    private val timeZone = TimeZone.currentSystemDefault()
    private val now = Clock.System.now()

    val tasks = listOf(
        Task(
            id = 1,
            title = "Подготовить презентацию",
            description = "Финальная версия для клиента",
            due = now
                .plus(2, DateTimeUnit.HOUR)
                .toLocalDateTime(timeZone),
            status = TaskStatus.IN_PROGRESS
        ),
        Task(
            id = 2,
            title = "Созвон с командой",
            description = "Обсуждение спринта",
            due = run {
                val intermediate = now
                    .plus(1, DateTimeUnit.DAY, timeZone)
                    .toLocalDateTime(timeZone)

                LocalDateTime(
                    year = intermediate.year,
                    monthNumber = intermediate.monthNumber,
                    dayOfMonth = intermediate.dayOfMonth,
                    hour = 16,
                    minute = 30,
                    second = 0,
                    nanosecond = 0
                )
            },
            status = TaskStatus.ACTIVE
        )
    )
}
