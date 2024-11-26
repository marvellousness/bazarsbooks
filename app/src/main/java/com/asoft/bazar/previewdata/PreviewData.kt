package com.asoft.bazar.previewdata

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.asoft.bazar.R
import com.asoft.bazar.features.onboarding.IntroItem

internal object PreviewData {

    @Composable
    fun introItems(): List<IntroItem> {
        return listOf(
            IntroItem(
                stringResource(R.string.intro_1_title),
                stringResource(R.string.intro_1_subtitle),
                stringResource(R.string.continue_text),
                R.drawable.intro_1
            ),
            IntroItem(
                stringResource(R.string.intro_2_title),
                stringResource(R.string.intro_2_subtitle),
                stringResource(R.string.get_started),
                R.drawable.intro_2
            ),
            IntroItem(
                stringResource(R.string.intro_3_title),
                stringResource(R.string.intro_3_subtitle),
                stringResource(R.string.get_started),
                R.drawable.intro_3
            )
        )
    }
}