package org.l3on1kl.project.feature.root

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.l3on1kl.project.core.ui.TasksNavScreen
import org.l3on1kl.project.core.ui.theme.ChronosTheme

@Composable
fun ChronosApp() {
    ChronosTheme {
        Navigator(TasksNavScreen)
    }
}
