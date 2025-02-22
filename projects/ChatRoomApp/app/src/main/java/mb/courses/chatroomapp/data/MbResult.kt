package mb.courses.chatroomapp.data

import java.lang.Exception

sealed class MbResult<out T> {
    data class Success<out T>(val data: T): MbResult<T>()
    data class Error(val exception: Exception): MbResult<Nothing>()
}