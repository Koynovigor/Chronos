package org.l3on1kl.project.core.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ChronosColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val background: Color,
    val surface: Color,
    val onSurface: Color,
    val outline: Color,
    val error: Color,
    val tertiary: Color,
    val success: Color,
    val warning: Color,
    val info: Color,
)

val LocalChronosColors =
    staticCompositionLocalOf<ChronosColors> {
        error("No ChronosColors provided")
    }

val lightChronosColors =
    ChronosColors(
        primary = Color(0xFF3366FF),
        onPrimary = Color.White,
        secondary = Color(0xFFE7EAF4),
        background = Color(0xFFF6F7F9),
        surface = Color.White,
        onSurface = Color(0xFF1C1C1E),
        outline = Color(0xFF5F5F5F),
        error = Color(0xFFFF3B30),
        tertiary = Color(0xFFA259FF),
        success = Color(0xFF30D158),
        warning = Color(0xFFFFD60A),
        info = Color(0xFF5AC8FA),
    )

val darkChronosColors =
    ChronosColors(
        primary = Color(0xFF3366FF),
        onPrimary = Color.White,
        secondary = Color(0xFF3A3A3C),
        background = Color(0xFF1C1C1E),
        surface = Color(0xFF2C2C2E),
        onSurface = Color.White,
        outline = Color(0xFF9CA5B0),
        error = Color(0xFFFF453A),
        tertiary = Color(0xFFBF5AF2),
        success = Color(0xFF32D74B),
        warning = Color(0xFFFFD60A),
        info = Color(0xFF64D2FF),
    )

fun ChronosColors.toLightColorScheme(): ColorScheme = lightColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    secondary = secondary,
    background = background,
    surface = surface,
    onSurface = onSurface,
    outline = outline,
    error = error,
    tertiary = tertiary,
)

fun ChronosColors.toDarkColorScheme(): ColorScheme = darkColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    secondary = secondary,
    background = background,
    surface = surface,
    onSurface = onSurface,
    outline = outline,
    error = error,
    tertiary = tertiary,
)
