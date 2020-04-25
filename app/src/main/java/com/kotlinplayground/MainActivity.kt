package com.kotlinplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.kotlinplayground.tmdb.ApiClient

class MainActivity : AppCompatActivity() {

    val TAG: String = "MainActivity"

    val name: String? = "String"

    val list: List<String>? = listOf("a", "b", "c")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate")
        val btnClick = findViewById<Button>(R.id.btn_click)
        btnClick?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // If name is not null assign name.length to l else assign -1
        val l: Int = if(name != null) name.length else -1

        //Above operation simplified using Elvis Operator
        val len = name?.length?:-1

        printStringsFromList(list)

    }

    private fun printStringsFromList(strings: List<String>?){
        for (s in strings!!)
            Log.i(TAG, s)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }
}
