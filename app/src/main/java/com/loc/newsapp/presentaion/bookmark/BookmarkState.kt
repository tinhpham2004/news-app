package com.loc.newsapp.presentaion.bookmark

import com.loc.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList(),

    )