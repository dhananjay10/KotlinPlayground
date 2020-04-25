package com.kotlinplayground.tmdb

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.alexdunn.wikipedia.models.WikiResult
import java.lang.reflect.Type

class WikiResultDeserializer: JsonDeserializer<WikiResult> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): WikiResult {
        val response = json!!.asJsonObject
        return Gson().fromJson(response, WikiResult::class.java)
    }
}