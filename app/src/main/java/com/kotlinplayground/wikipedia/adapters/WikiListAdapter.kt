package com.kotlinplayground.wikipedia.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinplayground.R
import com.kotlinplayground.wikipedia.data.WikiPage
import com.kotlinplayground.wikipedia.viewholders.WikiViewHolder

class WikiListAdapter(): RecyclerView.Adapter<WikiViewHolder>() {

    val wikiList: ArrayList<WikiPage> = ArrayList<WikiPage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WikiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wiki, parent, false)
        return WikiViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wikiList.size;
    }

    override fun onBindViewHolder(holder: WikiViewHolder, position: Int) {
        val page = wikiList[position]
        holder.bindData(page)
    }
}