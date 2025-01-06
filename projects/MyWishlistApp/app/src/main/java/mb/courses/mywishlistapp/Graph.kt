package mb.courses.mywishlistapp

import android.content.Context
import androidx.room.Room
import mb.courses.mywishlistapp.data.WishDatabase
import mb.courses.mywishlistapp.data.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}