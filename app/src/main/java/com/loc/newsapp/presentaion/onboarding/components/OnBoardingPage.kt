package com.loc.newsapp.presentaion.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.loc.newsapp.R
import com.loc.newsapp.presentaion.Dimens.MediumPadding1
import com.loc.newsapp.presentaion.Dimens.MediumPadding2
import com.loc.newsapp.presentaion.onboarding.Page

/**
 * A composable function that represents a single page in the onboarding flow.
 *
 * @param modifier A [Modifier] for this composable.
 * @param page A [Page] object that contains the data for this onboarding page.
 */

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier, page: Page) {
    Column(modifier = Modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }
}