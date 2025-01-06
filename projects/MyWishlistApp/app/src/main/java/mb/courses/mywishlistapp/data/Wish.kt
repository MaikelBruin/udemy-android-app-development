package mb.courses.mywishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish {
    val wishList: List<Wish> = listOf(
        Wish(title = "Google watch 2", description = "Android watch"),
        Wish(title = "Book", description = "For reading"),
        Wish(title = "PS5", description = "For gaming")
    )
}
