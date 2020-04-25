package com.kotlinplayground.tmdb

import com.kotlinplayground.wikipedia.Urls
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val instance: ApiService = Retrofit.Builder().run {
        /*val gson = GsonBuilder()
            .registerTypeAdapter(WikiResult::class.java, WikiResultDeserializer())
            .create()*/
        baseUrl(Urls.BaseUrl)
        addConverterFactory(GsonConverterFactory.create())
        client(createRequestInterceptorClient())
        build()
    }.create(ApiService::class.java)

    private fun createRequestInterceptorClient(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            val request = requestBuilder.build()
            request.header("User-Agent DK Wiki")
            chain.proceed(request)
        }
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}