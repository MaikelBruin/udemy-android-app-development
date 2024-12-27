package com.example.kotlinbasics

fun main() {
    //immutable
    val shoppingList = listOf("Processor", "RAM", "Graphics", "SSD")
    //mutable
    val mutableShoppingList = mutableListOf("Processor", "RAM", "Graphics", "SSD")
    mutableShoppingList.add("Cooling system")
    mutableShoppingList.remove("Processor")
    mutableShoppingList.add("Better processor")
    println(mutableShoppingList)
    println(mutableShoppingList[2])
    mutableShoppingList[2] = "Better SSD"
    println(mutableShoppingList)
    mutableShoppingList[2] = "Original SSD"
    println(mutableShoppingList)
}
