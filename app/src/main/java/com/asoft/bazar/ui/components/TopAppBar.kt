package com.asoft.bazar.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.asoft.bazar.ui.theme.BazarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BazarTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = BazarTheme.colors.background,
        titleContentColor = BazarTheme.colors.primary,
        navigationIconContentColor = BazarTheme.colors.primary,
    )
) {
    CenterAlignedTopAppBar(
        modifier = modifier.padding(horizontal = 0.dp),
        title = title,
        navigationIcon = navigationIcon,
        actions = actions,
        windowInsets = windowInsets,
        colors = colors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BazarTopAppBar(
    @StringRes titleResourceId: Int,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets
) {
    BazarTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = titleResourceId),
                style = BazarTheme.typography.bodyLarge,
                color = BazarTheme.colors.background,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        windowInsets = windowInsets
    )
}