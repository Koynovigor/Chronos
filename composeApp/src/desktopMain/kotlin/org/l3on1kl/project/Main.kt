package org.l3on1kl.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.l3on1kl.project.core.ui.theme.ThemeRepository
import org.l3on1kl.project.core.utils.PlatformSettingsFactory
import org.l3on1kl.project.feature.root.ChronosApp

fun main() =
    application {
        val themeRepository = ThemeRepository(PlatformSettingsFactory.create())
        Window(onCloseRequest = ::exitApplication, title = "Chronos") {
            ChronosApp(themeRepository)
        }
    }
