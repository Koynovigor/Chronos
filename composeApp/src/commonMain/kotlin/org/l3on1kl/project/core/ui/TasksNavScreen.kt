package org.l3on1kl.project.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
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
import androidx.compose.ui.draw.drawWithContent
import cafe.adriel.voyager.core.screen.Screen
import org.l3on1kl.project.core.ui.model.ChronosTab
import org.l3on1kl.project.core.ui.screens.SettingsScreen
import org.l3on1kl.project.core.ui.screens.TaskListScreen
import org.l3on1kl.project.core.ui.theme.AppTheme

data class TasksNavScreen(
    val onThemeChange: (AppTheme) -> Unit
) : Screen {

    @Composable
    override fun Content() {
        TasksNavScreenContent(onThemeChange)
    }
}

@Composable
fun TasksNavScreenContent(onThemeChange: (AppTheme) -> Unit) {
    var selectedTab by rememberSaveable { mutableStateOf(ChronosTab.Tasks) }

    Scaffold(
        modifier = Modifier
            .drawWithContent {
                drawContent()
            }
            .fillMaxSize()
            .systemBarsPadding(),
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
                ChronosTab.Settings -> SettingsScreen(onThemeChange)
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
