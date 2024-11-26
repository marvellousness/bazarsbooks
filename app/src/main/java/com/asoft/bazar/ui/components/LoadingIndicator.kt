package com.asoft.bazar.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asoft.bazar.ui.theme.BazarTheme

/**
 * Shows the default loading UI.
 *
 * @param modifier Modifier for styling.
 */
@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(strokeWidth = 2.dp, color = BazarTheme.colors.surfaceContainer)
    }
}

@Preview()
@Composable
private fun LoadingIndicatorPreview() {
    LoadingIndicator()
}
