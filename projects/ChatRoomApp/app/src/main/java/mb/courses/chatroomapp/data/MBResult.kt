package mb.courses.chatroomapp.data

import java.lang.Exception

sealed class MBResult<out T> {
    data class Success<out T>(val data: T): MBResult<T>()
    data class Error(val exception: Exception): MBResult<Nothing>()
}