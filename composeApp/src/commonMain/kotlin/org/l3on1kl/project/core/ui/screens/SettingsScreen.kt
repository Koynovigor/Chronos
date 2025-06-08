package org.l3on1kl.project.core.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.compose.stringResource
import org.l3on1kl.project.MR
import org.l3on1kl.project.core.ui.theme.AppTheme

@Composable
fun SettingsScreen(onThemeChange: (AppTheme) -> Unit) {
    Column {
        Text(text = stringResource(MR.strings.settings))

        Text(text = stringResource(MR.strings.choose_theme))

        Button(onClick = { onThemeChange(AppTheme.LIGHT) }) {
            Text(text = stringResource(MR.strings.theme_light))
        }

        Button(onClick = { onThemeChange(AppTheme.DARK) }) {
            Text(text = stringResource(MR.strings.theme_dark))
        }

        Button(onClick = { onThemeChange(AppTheme.SYSTEM) }) {
            Text(text = stringResource(MR.strings.theme_system))
        }
    }
}
