package com.asoft.bazar.features.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.asoft.bazar.R
import com.asoft.bazar.ui.theme.BazarTheme
import com.asoft.bazar.ui.theme.tokens.PaletteTokens

@Composable
fun TermOfServiceLink(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val text = buildAnnotatedString {
        withStyle(SpanStyle(color = PaletteTokens.GrayScale500)) {
            append(stringResource(id = R.string.terms_of_service_first))
            append(" ")
        }

        pushStringAnnotation(tag = "click", annotation = "click")
        withStyle(
            SpanStyle(
                color = BazarTheme.colors.primary,
                textDecoration = TextDecoration.None
            )
        ) {
            append(stringResource(id = R.string.terms_of_service_last))
        }
        pop()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier.clickable {
                val clickAnnotation =
                    text.getStringAnnotations(tag = "click", start = 0, end = text.length)
                        .firstOrNull()
                if (clickAnnotation != null) {
                    onClick()
                }
            },
            textAlign = TextAlign.Center
        )
    }
}