package com.asoft.bazar.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.asoft.bazar.ui.theme.tokens.LocalBazarColors
import com.asoft.bazar.ui.theme.tokens.LocalBazarShapes
import com.asoft.bazar.ui.theme.tokens.LocalBazarTypography

@Composable
fun BazarTheme(
    colors: ColorScheme = BazarTheme.colors,
    typography: Typography = BazarTheme.typography,
    shapes: Shapes = BazarTheme.shapes,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalBazarColors provides colors,
        LocalBazarTypography provides typography,
        LocalBazarShapes provides shapes
    ) {
        MaterialTheme(
            colorScheme = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object BazarTheme {

    val colors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalBazarColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalBazarTypography.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalBazarShapes.current
}