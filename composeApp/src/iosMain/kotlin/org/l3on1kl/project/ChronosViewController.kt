package org.l3on1kl.project

import androidx.compose.ui.window.ComposeUIViewController
import org.l3on1kl.project.feature.root.ChronosApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController =
    ComposeUIViewController { ChronosApp() }
