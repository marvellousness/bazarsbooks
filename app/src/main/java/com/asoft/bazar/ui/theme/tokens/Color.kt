package com.asoft.bazar.ui.theme.tokens

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.asoft.bazar.ui.theme.tokens.PaletteTokens.GrayScale200
import com.asoft.bazar.ui.theme.tokens.PaletteTokens.Primary200
import com.asoft.bazar.ui.theme.tokens.PaletteTokens.Primary500
import com.asoft.bazar.ui.theme.tokens.PaletteTokens.Yellow1
import com.asoft.bazar.ui.theme.tokens.PaletteTokens.Yellow2


internal val DarkColorScheme = darkColorScheme(
    primary = Primary200,
    secondary = GrayScale200,
    tertiary = Primary200
)

internal val LightColorScheme = lightColorScheme(
    primary = Primary500,
    secondary = GrayScale200,
    tertiary = Primary200,
    outline = GrayScale200,
    onPrimary = Color.White,
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

internal val LocalBazarColors = staticCompositionLocalOf { LightColorScheme }