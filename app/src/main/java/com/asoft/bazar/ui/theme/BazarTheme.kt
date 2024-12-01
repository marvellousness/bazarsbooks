package com.asoft.bazar.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.asoft.bazar.ui.theme.tokens.BazarSpacing
import com.asoft.bazar.ui.theme.tokens.DarkColorScheme
import com.asoft.bazar.ui.theme.tokens.LightColorScheme
import com.asoft.bazar.ui.theme.tokens.LocalBazarColors
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

    CompositionLocalProvider(
        LocalBazarColors provides colorScheme,
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