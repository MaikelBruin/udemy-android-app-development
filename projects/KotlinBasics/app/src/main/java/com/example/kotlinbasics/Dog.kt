package com.example.kotlinbasics

class Dog (val name: String, val breed: String){

    init {
        bark()
    }

    fun bark() {
        println("$name says Woof")
        println("$name is a $breed")
    }
}