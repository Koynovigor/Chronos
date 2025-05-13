package org.l3on1kl.project

import kotlin.test.Test
import kotlin.test.assertEquals

class CreateTaskUseCaseTest {

    @Test
    fun `created task has default state`() {
        val task = Task("Test")
        assertEquals("Test", task.title)
        assertEquals(false, task.isDone)
    }
}

data class Task(val title: String, val isDone: Boolean = false)
