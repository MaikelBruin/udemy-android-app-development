package mb.courses.mywishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    @Query("SELECT * FROM `WISH-TABLE`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Query("SELECT * FROM `wish-table` WHERE id =:wishId")
    abstract fun getWishById(wishId: Long): Flow<Wish>

}