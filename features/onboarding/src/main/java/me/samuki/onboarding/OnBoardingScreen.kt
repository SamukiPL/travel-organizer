package me.samuki.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@Composable
fun OnBoardingScreen(navigation: OnBoardingNavigation) {
    val viewModel: OnBoardingViewModel = hiltViewModel()
    viewModel.viewEvent {
        when (it) {
            OnBoardingViewModel.ViewEvent.EndOnBoarding -> navigation.createNewJourney()
        }
    }
    val pages = OnBoardingPage.values()
    OnBoardingContent(pages) {
        viewModel.endOnBoarding()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun OnBoardingContent(
    pages: Array<OnBoardingPage>, endOnBoarding: () -> Unit
) {
    val pagerState = rememberPagerState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary,
                        MaterialTheme.colors.primaryVariant,
                    )
                )
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            modifier = Modifier.weight(8f),
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) {
            Page(page = pages[it])
        }
        EndButton(Modifier.weight(1f), pagerState.currentPage == pages.size - 1, endOnBoarding)
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.weight(1f),
            activeColor = Color.White,
            inactiveColor = Color.LightGray
        )
    }
}

@Composable
private fun Page(
    modifier: Modifier = Modifier, page: OnBoardingPage
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(page.animation))
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .height(256.dp)
                .padding(top = 64.dp)
        )
        Text(
            text = stringResource(id = page.title),
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = stringResource(id = page.description),
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Composable
private fun EndButton(modifier: Modifier, isVisible: Boolean, endOnBoarding: () -> Unit) {
    Row(
        modifier = modifier.padding(horizontal = 32.dp)
    ) {
        AnimatedVisibility(
            visible = isVisible, modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(
                onClick = endOnBoarding,
                colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_create_button).uppercase(),
                    fontSize = 18.sp
                )
            }
        }
    }
}
