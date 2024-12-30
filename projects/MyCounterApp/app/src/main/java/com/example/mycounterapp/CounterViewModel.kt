package com.example.mycounterapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var _count = mutableStateOf(0)
    var count = _count.value


    fun increment() {
        _count.value++
    }

    fun decrement() {
        _count.value--
    }
}