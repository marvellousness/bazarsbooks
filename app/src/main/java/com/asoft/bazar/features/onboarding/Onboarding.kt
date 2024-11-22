package com.asoft.bazar.features.onboarding

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoft.bazar.R
import com.asoft.bazar.ui.components.BazarSurface
import com.asoft.bazar.ui.components.button.BazarButton
import com.asoft.bazar.ui.components.button.ButtonShape
import com.asoft.bazar.ui.components.button.ButtonSize
import com.asoft.bazar.ui.theme.BazarTheme
import com.asoft.bazar.ui.theme.tokens.PaletteTokens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen() {
    val introItems: List<IntroItem> = listOf(
        IntroItem(
            stringResource(R.string.intro_1_title),
            stringResource(R.string.intro_1_subtitle),
            R.drawable.intro_1
        ),
        IntroItem(
            stringResource(R.string.intro_2_title),
            stringResource(R.string.intro_2_subtitle),
            R.drawable.intro_2
        ),
        IntroItem(
            stringResource(R.string.intro_3_title),
            stringResource(R.string.intro_3_subtitle),
            R.drawable.intro_3
        )
    )
    BazarSurface {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                BazarButton(
                    onClick = {},
                    modifier = Modifier.padding(top = 15.dp, start = 15.dp),
                    text = "Skip",
                    colors = ButtonDefaults.outlinedButtonColors()
                )
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .weight(1f)
            ) {
                IntroView(itemsList = introItems)
            }
            BazarButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                size = ButtonSize.Medium,
                shape = ButtonShape.Pill,
                text = "Get Started",
            )
            BazarButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
                text = "Sign in",
                colors = ButtonDefaults.textButtonColors()
            )
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
    pagerState: PagerState = rememberPagerState(pageCount = { 3 }),
) {
    HorizontalPager(
        state = pagerState, modifier = Modifier.fillMaxWidth()
    ) { index ->
        DisplayIntro(itemsList[index])
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(
        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        repeat(itemsList.size) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) BazarTheme.colors.primary else BazarTheme.colors.secondary
            Box(
                modifier = Modifier
                    .padding(start = 2.dp, end = 2.dp, bottom = 5.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }
    }

    LaunchedEffect(key1 = pagerState.currentPage) {
        launch {
            delay(2000)
            with(pagerState) {
                val target = if (currentPage < itemsList.count() - 1) currentPage + 1 else 0

                animateScrollToPage(
                    page = target, animationSpec = tween(
                        durationMillis = 0, easing = FastOutLinearInEasing
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen()
}
