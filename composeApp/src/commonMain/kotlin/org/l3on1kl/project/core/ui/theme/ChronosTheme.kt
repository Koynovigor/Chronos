package org.l3on1kl.project.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightColors = lightColorScheme(
    primary = Color(0xFF3366FF),
    onPrimary = Color.White,
    secondary = Color(0xFFE7EAF4),
    background = Color(0xFFF6F7F9),
    surface = Color.White,
    onSurface = Color(0xFF1C1C1E),
    outline = Color(0xFFE1E3E6),
)


private val DarkColors = darkColorScheme(
    primary = Color(0xFF3366FF),
    onPrimary = Color.White,
    background = Color(0xFF1C1C1E),
    surface = Color(0xFF2C2C2E),
    onSurface = Color.White,
    outline = Color(0xFF3A3A3C),
)

@Composable
fun ChronosTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (useDarkTheme) DarkColors else LightColors,
        typography = ChronosTypography,
        shapes = ChronosShapes,
        content = content
    )
}

val ChronosTypography = Typography(
    titleLarge = Typography().titleLarge.copy(color = Color.Black),
    bodyMedium = Typography().bodyMedium,
    labelSmall = Typography().labelSmall
)

val ChronosShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(20.dp)
)
