package org.l3on1kl.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.l3on1kl.project.core.ui.theme.ThemeRepository
import org.l3on1kl.project.core.utils.PlatformSettingsFactory
import org.l3on1kl.project.feature.root.ChronosApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val themeRepository = ThemeRepository(PlatformSettingsFactory.create())
        setContent {
            ChronosApp(themeRepository)
        }
    }
}
