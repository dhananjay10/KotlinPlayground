package com.kotlinplayground.wikipedia.data

data class WikiPage (var pageid: Int? = null,
                var title: String? = null,
                var fullurl: String? = null,
                var thumbnail: WikiThumbnail) {
}