package com.example.kotlinbasics

fun main() {
    var daisy = Dog("Daisy", "Dwarf Poodle")
    println("${daisy.name} is a moron")

    val book = Book()
    println(book.author)
    println(book.title)
    println(book.yearPublished)

    val otherBook = Book("cool title", "myself", 1991)
    println(otherBook.author)
    println(otherBook.title)
    println(otherBook.yearPublished)
}
