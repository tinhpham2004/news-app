package com.loc.newsapp.presentaion.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.loc.newsapp.presentaion.Dimens.MediumPadding2
import com.loc.newsapp.presentaion.Dimens.PageIndicatorWidth
import com.loc.newsapp.presentaion.common.NewsButton
import com.loc.newsapp.presentaion.common.NewsTextButton
import com.loc.newsapp.presentaion.onboarding.components.OnBoardingPage
import com.loc.newsapp.presentaion.onboarding.components.PageIndicatior
import kotlinx.coroutines.launch

/**
 * Composable function to display the onboarding screen with a horizontal pager.
 *
 * @param modifier Modifier to be applied to the Column layout.
 */
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        // Remember the pager state with the initial page set to 0
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        // Derived state to update the navigation buttons based on the current page
        val buttonsState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        // Horizontal pager to display the onboarding pages
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        // Spacer to push the row with the page indicator to the bottom
        Spacer(modifier = Modifier.weight(1f))

        // Row to display the page indicator and navigation buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Page indicator to show the current page
            PageIndicatior(
                modifier = Modifier.width(PageIndicatorWidth),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

            // Row to display the navigation buttons
            Row(verticalAlignment = Alignment.CenterVertically) {

                // Remember the coroutine scope for launching coroutines
                val scope = rememberCoroutineScope()

                // Display the "Back" button if applicable
                if (buttonsState.value[0].isNotEmpty()) {
                    NewsTextButton(text = buttonsState.value[0], onClick = {
                        scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) }
                    })
                }

                // Display the "Next" or "Get Started" button
                NewsButton(text = buttonsState.value[1], onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            event(OnBoardingEvent.SaveAppEntry)
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                })
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}