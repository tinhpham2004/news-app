package com.loc.newsapp.presentaion.search

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null,
) {
}