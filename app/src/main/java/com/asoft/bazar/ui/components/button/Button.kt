package com.asoft.bazar.ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asoft.bazar.ui.components.icon.BazarIcon
import com.asoft.bazar.ui.theme.BazarTheme


@Composable
internal fun BaseBazarButton(
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier,
    size: ButtonSize = ButtonSize.Medium,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    shape: ButtonShape = ButtonShape.Rounded,
    border: BorderStroke? = null,
    icon: BazarIcon? = null,
    contentPadding: PaddingValues = PaddingValues(
        horizontal = 16.dp,
        vertical = size.contentVerticalPadding
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .defaultMinSize(minHeight = size.height),
        enabled = enabled,
        elevation = elevation,
        shape = shape.shape,
        border = border,
        colors = colors,
        interactionSource = interactionSource,
        contentPadding = contentPadding,
    ) {
        Row(
            modifier = Modifier.weight(weight = 1f, fill = false),
            content = content
        )
    }
}

@Composable
fun BazarButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    size: ButtonSize = ButtonSize.Medium,
    shape: ButtonShape = ButtonShape.Rounded,
    enabled: Boolean = true,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    icon: BazarIcon? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    BaseBazarButton(
        onClick = onClick,
        modifier = modifier,
        size = size,
        shape = shape,
        enabled = enabled,
        elevation = elevation,
        border = border,
        colors = colors,
        icon = icon,
        interactionSource = interactionSource
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    BazarTheme {
        BazarButton(
            text = "Button Button",
            onClick = {}
        )
    }
}