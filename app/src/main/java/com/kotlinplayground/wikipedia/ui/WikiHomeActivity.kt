package com.kotlinplayground.wikipedia.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kotlinplayground.R
import com.kotlinplayground.wikipedia.ui.fragment.ExploreFragment
import com.kotlinplayground.wikipedia.ui.fragment.FavoritesFragment
import com.kotlinplayground.wikipedia.ui.fragment.HistoryFragment

class WikiHomeActivity : AppCompatActivity() {

    private val exploreFragment: ExploreFragment = ExploreFragment.newInstance()
    private val historyFragment: HistoryFragment = HistoryFragment.newInstance()
    private val favoritesFragment: FavoritesFragment = FavoritesFragment.newInstance()

    private val onNavigationChangeListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

            when (item.itemId) {
                R.id.navigation_explore -> transaction.replace(
                    R.id.fragment_container,
                    exploreFragment
                )
                R.id.navigation_favorites -> transaction.replace(
                    R.id.fragment_container,
                    favoritesFragment
                )
                R.id.navigation_history -> transaction.replace(
                    R.id.fragment_container,
                    historyFragment
                )
            }
            transaction.commit()
            true
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wiki_home)

        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationChangeListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, exploreFragment)
        transaction.commit()

    }
}
