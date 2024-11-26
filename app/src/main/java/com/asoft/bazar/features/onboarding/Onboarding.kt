package com.asoft.bazar.features.onboarding

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asoft.bazar.R
import com.asoft.bazar.previewdata.PreviewData
import com.asoft.bazar.ui.components.BazarSurface
import com.asoft.bazar.ui.components.button.ButtonShape
import com.asoft.bazar.ui.components.button.PrimaryButton
import com.asoft.bazar.ui.components.button.SecondaryButton
import com.asoft.bazar.ui.components.button.TextButton
import com.asoft.bazar.ui.theme.BazarTheme
import com.asoft.bazar.ui.theme.tokens.PaletteTokens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen() {
    val introItems = PreviewData.introItems()
    val pagerState: PagerState = rememberPagerState(pageCount = { introItems.size })

    BazarSurface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                TextButton(
                    onClick = {},
                    modifier = Modifier.padding(top = 15.dp, start = 15.dp),
                    text = stringResource(R.string.skip),
                )
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .weight(1f)
            ) {
                IntroView(itemsList = introItems, pagerState)
            }
            PrimaryButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                shape = ButtonShape.Pill,
                text = introItems[pagerState.currentPage].buttonText,
            )
            SecondaryButton(
                shape = ButtonShape.Pill,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
                text = "Sign in",
            )
        }

        LaunchedEffect(key1 = pagerState.currentPage) {
            launch {
                delay(2000)
                with(pagerState) {
                    val target = if (currentPage < introItems.count() - 1) currentPage + 1 else 0

                    animateScrollToPage(
                        page = target, animationSpec = tween(
                            durationMillis = 0, easing = FastOutLinearInEasing
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayIntro(item: IntroItem) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(320.dp)
                .height(320.dp),
            painter = painterResource(item.drawableRes),
            contentDescription = null
        )

        Text(
            text = item.title,
            style = BazarTheme.typography.headlineSmall,
            color = Color.Black,
            textAlign = TextAlign.Center,
            minLines = 2,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 70.dp)
        )

        Text(
            text = item.subtitle,
            style = BazarTheme.typography.bodyLarge,
            color = PaletteTokens.GrayScale500,
            minLines = 3,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
                .padding(horizontal = 4.dp, vertical = 2.dp)
        )
    }
}

@Composable
fun IntroView(
    itemsList: List<IntroItem> = listOf(),
    pagerState: PagerState,
) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth()
    ) { index ->
        DisplayIntro(itemsList[index])
    }
    Spacer(modifier = Modifier.height(20.dp))
    IntroPagerIndicator(itemsList, pagerState)
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen()
}
