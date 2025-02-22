package mb.courses.chatroomapp.data

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RoomRepository(private val firestore: FirebaseFirestore) {
    suspend fun createRoom(name: String): MbResult<Unit> = try {
        val room = Room(name = name)
        firestore.collection("rooms").add(room).await()
        MbResult.Success(Unit)
    } catch (e: Exception) {
        MbResult.Error(e)
    }

    suspend fun getRooms(): MbResult<List<Room>> = try {
        val querySnapshot = firestore.collection("rooms").get().await()
        val rooms = querySnapshot.documents.map { document ->
            document.toObject(Room::class.java)!!.copy(id = document.id)
        }
        MbResult.Success(rooms)
    } catch (e: Exception) {
        MbResult.Error(e)
    }


}