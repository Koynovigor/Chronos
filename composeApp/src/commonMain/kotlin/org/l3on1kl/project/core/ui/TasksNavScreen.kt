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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.currentOrThrow
import org.l3on1kl.project.core.db.DatabaseFactory
import org.l3on1kl.project.core.ui.model.ChronosTab
import org.l3on1kl.project.core.ui.screens.CreateTaskScreen
import org.l3on1kl.project.core.ui.screens.SettingsScreen
import org.l3on1kl.project.core.ui.screens.TaskListScreen
import org.l3on1kl.project.core.ui.theme.AppTheme
import org.l3on1kl.project.feature.tasks.data.TaskRepositoryImpl
import org.l3on1kl.project.feature.tasks.presentation.TaskListViewModel

data class TasksNavScreen(
    val onThemeChange: (AppTheme) -> Unit,
    val databaseFactory: DatabaseFactory
) : Screen {

    @Composable
    override fun Content() {
        TasksNavScreenContent(
            onThemeChange,
            databaseFactory
        )
    }
}

@Composable
fun TasksNavScreenContent(
    onThemeChange: (AppTheme) -> Unit,
    databaseFactory: DatabaseFactory
) {
    var selectedTab by rememberSaveable { mutableStateOf(ChronosTab.Tasks) }
    val navigator = cafe.adriel.voyager.navigator.LocalNavigator.currentOrThrow

    val db = remember { databaseFactory.createDatabase() }
    val repository = remember { TaskRepositoryImpl(db) }
    val viewModel = remember { TaskListViewModel(repository) }

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
                onTabClick = { selectedTab = it },
                onAddClick = {
                    navigator.push(
                        CreateTaskScreen(
                            onTaskSaved = { navigator.pop() },
                            viewModel = viewModel
                        )
                    )
                }
            )
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when (selectedTab) {
                ChronosTab.Tasks -> TaskListScreen(viewModel)
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
