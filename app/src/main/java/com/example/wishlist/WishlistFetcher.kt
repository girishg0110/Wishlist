package com.example.wishlist

class WishlistFetcher {
    companion object {
        val names = listOf("Television", "Playstation")
        val prices = listOf("$399.99", "$679.99")
        val urls = listOf("www.amazon.com", "www.walmart.com")
        fun getItems(): MutableList<WishlistEntry> {
            var items : MutableList<WishlistEntry> = ArrayList()
            for (i in names.indices) {
                val item = WishlistEntry(names[i], prices[i], urls[i])
                items.add(item)
            }
            return items
        }

        fun getNext5Emails(): MutableList<WishlistEntry> {
            var newItems : MutableList<WishlistEntry> = ArrayList()
            for (i in 0..4) {
                val item = WishlistEntry(names[i], prices[i], urls[i])
                newItems.add(item)
            }
            return newItems
        }
    }
}

