package com.kotlinplayground.wikipedia.viewholders

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlinplayground.R
import com.kotlinplayground.wikipedia.data.WikiPage
import kotlinx.android.synthetic.main.item_wiki.view.*

class WikiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var tvArticleTitle: TextView = itemView.findViewById(R.id.tv_article_title)
    private val ivThumbNail: ImageView = itemView.findViewById(R.id.iv_thumbnail)
    private var container: ConstraintLayout = itemView.findViewById(R.id.container)

    init {
        container.setOnClickListener {
        }
    }

    fun bindData(page: WikiPage) {
        tvArticleTitle.text = page.title
        if (page.thumbnail != null) {
            Glide.with(ivThumbNail.context)
                .load(page.thumbnail.source)
                .error(R.drawable.ic_error)
                .into(ivThumbNail)
        } else {
            Glide.with(ivThumbNail.context)
                .load(R.drawable.ic_error)
                .into(ivThumbNail)
        }
    }
}