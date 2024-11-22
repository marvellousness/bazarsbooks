package com.asoft.bazar.ui.components.icon

import androidx.compose.ui.graphics.vector.ImageVector

sealed class BazarIcon {
    data class DrawableRes(@androidx.annotation.DrawableRes val drawableId: Int) : BazarIcon()
    data class Vector(val imageVector: ImageVector) : BazarIcon()
}
