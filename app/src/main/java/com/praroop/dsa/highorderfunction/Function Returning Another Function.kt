package com.praroop.dsa.highorderfunction

fun main() {
val operation=getOperation("add")
val operation1=getOperation("multiply")
    println("Operation "+operation(3,4))
    println("Operation "+operation1(3,4))
}

fun getOperation(type: String): (Int, Int) -> Int {
    return when (type) {
        "add" -> { a, b -> a + b }
        "multiply" -> { a, b -> a * b }
        else -> { _, _ -> 0 }
    }
}