package org.l3on1kl.project.core.ui.theme

import com.russhwolf.settings.Settings

class ThemeRepository(private val settings: Settings) {

    companion object {
        private const val THEME_KEY = "app_theme"
    }

    fun getTheme(): AppTheme {
        val name = settings.getString(THEME_KEY, AppTheme.SYSTEM.name)
        return AppTheme.valueOf(name)
    }

    fun setTheme(theme: AppTheme) {
        settings.putString(THEME_KEY, theme.name)
    }
}
