package com.loc.newsapp.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val selectArticles: SelectArticles,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticle: SelectArticle
)
