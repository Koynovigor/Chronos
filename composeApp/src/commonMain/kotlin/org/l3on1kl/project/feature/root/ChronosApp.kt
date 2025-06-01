package org.l3on1kl.project.feature.root

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.l3on1kl.project.core.ui.TasksNavScreen

@Composable
fun ChronosApp() {
    MaterialTheme {
        Navigator(TasksNavScreen)
    }
}
