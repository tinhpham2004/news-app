package com.loc.newsapp.presentaion.search

sealed class SearchEvent {
    data class OnSearchQueryChanged(val searchQuery: String) : SearchEvent()
    object OnSearch : SearchEvent()

}