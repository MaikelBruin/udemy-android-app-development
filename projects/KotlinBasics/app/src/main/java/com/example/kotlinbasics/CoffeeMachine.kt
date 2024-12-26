package com.example.kotlinbasics

fun main(){
    makeCoffee(1, "MB")
    makeCoffee(2, "Els")
    makeCoffee(30, "Sjaak")

}



fun makeCoffee(sugarCount : Int, name: String){
    if (sugarCount == 1) {
        println("Coffee with 1 spoon of sugar for $name")
    } else {
        println("Coffee with $sugarCount spoons of sugar for $name")
    }
}