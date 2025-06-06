package org.l3on1kl.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.l3on1kl.project.feature.root.ChronosApp

fun main() =
    application {
        Window(onCloseRequest = ::exitApplication, title = "Chronos") {
            ChronosApp()
        }
    }
