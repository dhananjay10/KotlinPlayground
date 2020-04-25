package org.alexdunn.wikipedia.models

import com.kotlinplayground.wikipedia.data.WikiPage

data class WikiQueryData(val pages: ArrayList<WikiPage> = ArrayList<WikiPage>()) {

}