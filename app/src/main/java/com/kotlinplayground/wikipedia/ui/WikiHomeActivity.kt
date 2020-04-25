package com.kotlinplayground.wikipedia.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlinplayground.R
import com.kotlinplayground.tmdb.ApiClient
import com.kotlinplayground.wikipedia.adapters.WikiListAdapter
import org.alexdunn.wikipedia.models.WikiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WikiHomeActivity : AppCompatActivity() {

    var rvWiki: RecyclerView? = null
    var wikiListAdapter: WikiListAdapter? = WikiListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wiki_home)
        rvWiki = findViewById(R.id.rv_wiki)
        rvWiki!!.layoutManager = LinearLayoutManager(this)
        rvWiki!!.adapter = wikiListAdapter

        val call = ApiClient.instance.
            getRasndomArticles()
        call.enqueue(object: Callback<WikiResult>{
            override fun onResponse(call: Call<WikiResult>, response: Response<WikiResult>) {
                wikiListAdapter!!.wikiList.clear()
                wikiListAdapter!!.wikiList.addAll(response.body()!!.query!!.pages)
                wikiListAdapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<WikiResult>, t: Throwable) {
                Log.d("@@", "Failure " + t.message)
            }
        })

    }
}
