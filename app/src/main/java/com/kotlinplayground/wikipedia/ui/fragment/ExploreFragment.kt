package com.kotlinplayground.wikipedia.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlinplayground.R
import com.kotlinplayground.tmdb.ApiClient
import com.kotlinplayground.wikipedia.adapters.WikiListAdapter
import org.alexdunn.wikipedia.models.WikiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreFragment : Fragment() {

    var rvWiki: RecyclerView? = null
    var wikiListAdapter: WikiListAdapter? = WikiListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false);
        getArticles(view)
        return view
    }

    private fun getArticles(view: View){
        rvWiki = view.findViewById(R.id.rv_wiki)
        rvWiki!!.layoutManager = LinearLayoutManager(activity)
        rvWiki!!.adapter = wikiListAdapter

        val call = ApiClient.instance.
            getRasndomArticles()

        call.enqueue(object: Callback<WikiResult> {
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

    companion object {
        @JvmStatic
        fun newInstance() = ExploreFragment()
    }
}
