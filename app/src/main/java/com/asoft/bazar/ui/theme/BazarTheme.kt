package com.asoft.bazar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.asoft.bazar.ui.theme.tokens.BazarSpacing
import com.asoft.bazar.ui.theme.tokens.DarkColorScheme
import com.asoft.bazar.ui.theme.tokens.DarkExtendedColorScheme
import com.asoft.bazar.ui.theme.tokens.ExtendedColorScheme
import com.asoft.bazar.ui.theme.tokens.LightColorScheme
import com.asoft.bazar.ui.theme.tokens.LightExtendedColorScheme
import com.asoft.bazar.ui.theme.tokens.LocalBazarColors
import com.asoft.bazar.ui.theme.tokens.LocalBazarExtendedColors
import com.asoft.bazar.ui.theme.tokens.LocalBazarShapes
import com.asoft.bazar.ui.theme.tokens.LocalBazarSpacing
import com.asoft.bazar.ui.theme.tokens.LocalBazarTypography

@Composable
fun BazarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: Typography = BazarTheme.typography,
    shapes: Shapes = BazarTheme.shapes,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val extendedColorScheme = when {
        darkTheme -> DarkExtendedColorScheme
        else -> LightExtendedColorScheme
    }

    CompositionLocalProvider(
        LocalBazarColors provides colorScheme,
        LocalBazarExtendedColors provides extendedColorScheme,
        LocalBazarTypography provides typography,
        LocalBazarShapes provides shapes
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
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

    val extendedColors: ExtendedColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalBazarExtendedColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = LocalBazarTypography.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalBazarShapes.current

    val spacing: BazarSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalBazarSpacing.current
}