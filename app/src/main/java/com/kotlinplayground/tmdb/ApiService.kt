package com.kotlinplayground.tmdb

import com.kotlinplayground.wikipedia.data.WikiPage
import org.alexdunn.wikipedia.models.WikiQueryData
import org.alexdunn.wikipedia.models.WikiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("discover/movie?")
    fun getMovies(@QueryMap map: QueryMap): Callback<MovieResult>

    @GET("?action=query&formatversion=2" +
            "&generator=prefixsearch&gpssearch={term}&gpslimit={take}&gpsoffset={skip}" +
            "&prop=pageimages|info&piprop=thumbnail|url&pithumbsize=200&pilimit={take}" +
            "&wbptterms=description&format=json&inprop=url")
    fun searchArticles(@Query("term") term:String, @Query("take") take:Int, @Query("skip") skip:Int): Callback<ArrayList<WikiPage>>

    @GET("?action=query"+
    "&format=json" +
    "&formatversion=2" +
    "&generator=random" +
    "&grnnamespace=0" +
    "&prop=pageimages|info" +
    "&grnlimit=10" +
    "&inprop=url" +
    "&pithumbsize=200")
    fun getRasndomArticles(): Call<WikiResult>
}