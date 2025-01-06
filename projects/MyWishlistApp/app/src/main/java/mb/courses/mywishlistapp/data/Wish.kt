package mb.courses.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "wish-title") val title: String = "",
    @ColumnInfo(name = "wish-descr") val description: String = ""
)

object DummyWish {
    val wishList: List<Wish> = listOf(
        Wish(title = "Google watch 2", description = "Android watch"),
        Wish(title = "Book", description = "For reading"),
        Wish(title = "PS5", description = "For gaming")
    )
}
