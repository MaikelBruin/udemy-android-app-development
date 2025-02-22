package mb.courses.chatroomapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mb.courses.chatroomapp.Injection
import mb.courses.chatroomapp.data.MbResult
import mb.courses.chatroomapp.data.Room
import mb.courses.chatroomapp.data.RoomRepository

class RoomViewModel : ViewModel() {
    private val _rooms = MutableLiveData<List<Room>>()
    val rooms: LiveData<List<Room>> get() = _rooms
    private val roomRepository: RoomRepository

    init {
        roomRepository = RoomRepository(Injection.instance())
        loadRooms()
    }

    fun createRoom(name: String) {
        viewModelScope.launch {
            roomRepository.createRoom(name)
        }
    }

    fun loadRooms() {
        viewModelScope.launch {
            when (val result = roomRepository.getRooms()) {
                is MbResult.Success -> _rooms.value = result.data
                is Error -> {

                }

                is MbResult.Error -> TODO()
            }
        }
    }
}