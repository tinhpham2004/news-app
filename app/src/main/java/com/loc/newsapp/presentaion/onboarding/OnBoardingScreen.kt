package com.loc.newsapp.presentaion.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.loc.newsapp.presentaion.onboarding.components.OnBoardingPage

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxHeight()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonsState = remember{
            derivedStateOf {
                when(pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
    }
}