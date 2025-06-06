package org.l3on1kl.project.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import org.l3on1kl.project.core.ui.model.ChronosTab
import org.l3on1kl.project.core.ui.screens.TaskListScreen

object TasksNavScreen : Screen {
    @Composable
    override fun Content() {
        var selectedTab by rememberSaveable { mutableStateOf(ChronosTab.Tasks) }

        Scaffold(
            bottomBar = {
                BottomBar(
                    currentTab = selectedTab,
                    onTabClick = { selectedTab = it }
                )
            }
        ) { padding ->
            Box(Modifier.padding(padding)) {
                when (selectedTab) {
                    ChronosTab.Tasks -> TaskListScreen()
                    ChronosTab.Calendar -> PlaceholderScreen("Календарь") // пока TODO
                    ChronosTab.Statistics -> PlaceholderScreen("Статистика") // пока TODO
                    ChronosTab.Settings -> PlaceholderScreen("Настройки") // пока TODO
                }
            }
        }
    }

}

@Composable
fun PlaceholderScreen(label: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Экран '$label' — TODO",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

