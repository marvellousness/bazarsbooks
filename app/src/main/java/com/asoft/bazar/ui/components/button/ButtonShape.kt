package com.asoft.bazar.ui.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import com.asoft.bazar.ui.theme.BazarTheme

enum class ButtonShape {
    Square {
        override val shape: Shape
            @Composable get() = BazarTheme.shapes.small
    },

    Pill {
        override val shape: Shape
            @Composable get() = BazarTheme.shapes.medium
    },

    Rounded {
        override val shape: Shape
            @Composable get() = BazarTheme.shapes.extraLarge
    },
    ;

    internal abstract val shape: Shape
        @Composable get
}
