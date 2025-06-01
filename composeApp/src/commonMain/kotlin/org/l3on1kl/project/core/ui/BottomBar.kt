package org.l3on1kl.project.core.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

@Composable
fun BottomBar() {
    val navigator = LocalNavigator.currentOrThrow
    val current = navigator.lastItem

    NavigationBar {
        NavigationBarItem(
            selected = current.key == TasksNavScreen.key,
            onClick = { navigator.push(TasksNavScreen) },
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Задачи") },
            label = { Text("Задачи") }
        )

        NavigationBarItem(
            selected = current.key == "Календарь",
            onClick = { navigator.push(placeholderScreen("Календарь")) },
            icon = { Icon(Icons.Default.CalendarToday, contentDescription = "Календарь") },
            label = { Text("Календарь") }
        )

        NavigationBarItem(
            selected = current.key == "Статистика",
            onClick = { navigator.push(placeholderScreen("Статистика")) },
            icon = { Icon(Icons.Default.BarChart, contentDescription = "Статистика") },
            label = { Text("Статистика") }
        )

        NavigationBarItem(
            selected = current.key == "Настройки",
            onClick = { navigator.push(placeholderScreen("Настройки")) },
            icon = { Icon(Icons.Default.Settings, contentDescription = "Настройки") },
            label = { Text("Настройки") }
        )
    }
}

