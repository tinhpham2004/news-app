package com.loc.newsapp.presentaion.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentaion.Dimens.ExtraSmallPaddig2
import com.loc.newsapp.presentaion.Dimens.MediumPadding1

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onClick: (Article) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(MediumPadding1),
        contentPadding = PaddingValues(all = ExtraSmallPaddig2)
    ) {
        items(articles.size) {
            val article = articles[it]
            ArticleCard(
                article = article,
                onClick = { onClick(article) }
            )

        }
    }

}

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPaddig2)
        ) {
            items(articles.itemCount) {
                articles[it]?.let {
                    ArticleCard(
                        article = it,
                        onClick = { onClick(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(
    articles: LazyPagingItems<Article>,
): Boolean {
    val loadSate = articles.loadState
    val error = when {
        loadSate.refresh is LoadState.Error -> loadSate.refresh as LoadState.Error
        loadSate.prepend is LoadState.Error -> loadSate.prepend as LoadState.Error
        loadSate.append is LoadState.Error -> loadSate.append as LoadState.Error
        else -> null
    }

    return when {
        loadSate.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            // Show error message
            false
        }

        else -> {
            // Show list
            true
        }
    }
}

@Composable
private fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}
