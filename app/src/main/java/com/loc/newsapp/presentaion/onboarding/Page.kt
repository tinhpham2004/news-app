package com.loc.newsapp.presentaion.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

/**
 * Data class representing a page in the onboarding flow.
 *
 * @property title The title of the onboarding page.
 * @property description The description of the onboarding page.
 * @property image The drawable resource ID for the image of the onboarding page.
 */
data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

/**
 * A list of pages to be displayed in the onboarding flow.
 */
val pages = listOf(
    Page(
        title = "Welcome to NewsApp",
        description = "Get the latest news from around the world",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Stay Updated",
        description = "Get the latest news from around the world",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Stay Informed",
        description = "Get the latest news from around the world",
        image = R.drawable.onboarding3
    )
)