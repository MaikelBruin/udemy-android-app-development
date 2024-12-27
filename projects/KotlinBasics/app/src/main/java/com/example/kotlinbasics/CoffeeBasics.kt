package com.example.kotlinbasics

data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)

fun main() {
    val coffee = CoffeeDetails(1, "MB", "S", 3)
    println(coffee.toString())
    println(makeCoffee(coffee))
}

fun makeCoffee(coffeeDetails: CoffeeDetails){
    if (coffeeDetails.sugarCount == 1) {
        println("Coffee with 1 spoon of sugar for ${coffeeDetails.name}")
    } else if (coffeeDetails.sugarCount == 0) {
        println("Coffee without sugar for ${coffeeDetails.name}")
    } else {
        println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}")
    }
}
