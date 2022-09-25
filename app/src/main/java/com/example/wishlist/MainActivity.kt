package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var items: MutableList<WishlistEntry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishlistRv = findViewById<RecyclerView>(R.id.wishlistRv)
        items = WishlistFetcher.getItems()
        val adapter = WishlistAdapter(items)
        wishlistRv.adapter = adapter
        wishlistRv.layoutManager = LinearLayoutManager(this)

        val nameField = findViewById<TextView>(R.id.nameField)
        val priceField = findViewById<TextView>(R.id.priceField)
        val urlField = findViewById<TextView>(R.id.urlField)
        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            val newWishlistEntry = WishlistEntry(nameField.text.toString(), "$" + priceField.text.toString(), urlField.text.toString())
            items.add(newWishlistEntry)
            adapter.notifyItemInserted(items.size - 1)
        }

    }
}