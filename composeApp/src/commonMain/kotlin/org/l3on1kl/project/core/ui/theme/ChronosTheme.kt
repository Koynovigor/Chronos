package org.l3on1kl.project.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChronosTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = if (useDarkTheme) darkChronosColors else lightChronosColors

    CompositionLocalProvider(LocalChronosColors provides colors) {
        MaterialTheme(
            colorScheme = if (useDarkTheme) colors.toDarkColorScheme() else colors.toLightColorScheme(),
            typography = ChronosTypography,
            shapes = ChronosShapes,
            content = content,
        )
    }
}

val ChronosTypography =
    Typography(
        titleLarge = Typography().titleLarge.copy(color = Color.Black),
        bodyMedium = Typography().bodyMedium,
        labelSmall = Typography().labelSmall,
    )

val ChronosShapes =
    Shapes(
        small = RoundedCornerShape(8.dp),
        medium = RoundedCornerShape(12.dp),
        large = RoundedCornerShape(20.dp),
    )

object ChronosTheme {
    val colors: ChronosColors
        @Composable
        get() = LocalChronosColors.current

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes
}
