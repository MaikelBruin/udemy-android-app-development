package com.example.kotlinbasics

fun main() {
    val fruitsList = mutableListOf("Apple", "Orange", "Pear", "Kiwi", "Jack-fruit")
    fruitsList.add("Mandarin")
    for (index in  0 until fruitsList.size) {
        println(index)
    }

    for (item in fruitsList) {
        println(item)
    }

    val numbers = mutableListOf(1, 2, 3, 4, 5)
    for (index in 0 until numbers.size) {
        numbers[index] = numbers[index] * 2
    }

    for (item in numbers) {
        println(item)
    }
}
