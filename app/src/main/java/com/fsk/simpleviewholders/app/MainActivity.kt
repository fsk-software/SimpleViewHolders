package com.fsk.simpleviewholders.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.recyclerview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groceriesAdapter = GroceriesAdapter().apply {
            missingItems =
                listOf("Apples", "Bananas", "Carrots", "Onions", "Lettuce", "Oranges", "Cabbage")

            foundItems = listOf("Bread", "Garlic", "Tomatoes")
        }

        recyclerview.apply {
            adapter = groceriesAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

    }
}