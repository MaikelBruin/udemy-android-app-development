package mb.courses.chatroomapp.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository(private val auth: FirebaseAuth, private val firestore: FirebaseFirestore) {
    suspend fun signUp(
        email: String, password: String, firstName: String, lastName: String
    ): MbResult<Boolean> = try {
        auth.createUserWithEmailAndPassword(email, password).await()
        val user = User(firstName, lastName, email)
        saveUserToFirestore(user)
        MbResult.Success(true)
    } catch (e: Exception) {
        MbResult.Error(e)
    }

    suspend fun login(email: String, password: String): MbResult<Boolean> = try {
        auth.signInWithEmailAndPassword(email, password).await()
        MbResult.Success(true)
    } catch (e: Exception) {
        MbResult.Error(e)
    }

    private suspend fun saveUserToFirestore(user: User) {
        firestore.collection("users").document(user.email).set(user).await()
    }


}