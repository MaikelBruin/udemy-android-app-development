package mb.courses.chatroomapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import mb.courses.chatroomapp.data.MBResult
import mb.courses.chatroomapp.data.UserRepository

class AuthViewModel : ViewModel() {
    private val userRepository: UserRepository

    object Injection {
        private val instance: FirebaseFirestore by lazy {
            FirebaseFirestore.getInstance()
        }

        fun instance(): FirebaseFirestore {
            return instance
        }
    }

    init {
        userRepository = UserRepository(
            FirebaseAuth.getInstance(),
            Injection.instance()
        )
    }

    private val _authResult = MutableLiveData<MBResult<Boolean>>()
    val authResult: LiveData<MBResult<Boolean>> get() = _authResult

    fun signup(email: String, password: String, firstName: String, lastName: String) {
        viewModelScope.launch {
            _authResult.value = userRepository.signUp(email, password, firstName, lastName)

        }
    }
}