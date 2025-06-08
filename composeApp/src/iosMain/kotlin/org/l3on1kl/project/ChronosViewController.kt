package org.l3on1kl.project

import androidx.compose.ui.window.ComposeUIViewController
import org.l3on1kl.project.core.ui.theme.ThemeRepository
import org.l3on1kl.project.core.utils.PlatformSettingsFactory
import org.l3on1kl.project.feature.root.ChronosApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val themeRepository = ThemeRepository(PlatformSettingsFactory.create())
    return ComposeUIViewController { ChronosApp(themeRepository) }
}
