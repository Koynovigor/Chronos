package org.l3on1kl.project.feature.root

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.Navigator
import org.l3on1kl.project.core.db.DatabaseFactory
import org.l3on1kl.project.core.ui.TasksNavScreen
import org.l3on1kl.project.core.ui.theme.AppTheme
import org.l3on1kl.project.core.ui.theme.ChronosTheme
import org.l3on1kl.project.core.ui.theme.ThemeRepository

@Composable
fun ChronosApp(
    themeRepository: ThemeRepository,
    databaseFactory: DatabaseFactory
) {
    val themeState = remember { mutableStateOf(themeRepository.getTheme()) }

    val isDarkTheme = when (themeState.value) {
        AppTheme.DARK -> true
        AppTheme.LIGHT -> false
        AppTheme.SYSTEM -> isSystemInDarkTheme()
    }

    ChronosTheme(useDarkTheme = isDarkTheme) {
        Navigator(
            TasksNavScreen(
                onThemeChange = { newTheme ->
                    themeRepository.setTheme(newTheme)
                    themeState.value = newTheme
                },
                databaseFactory = databaseFactory
            )
        )
    }
}
