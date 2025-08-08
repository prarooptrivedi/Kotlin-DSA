package com.praroop.dsa.Arrays

// Program: Count the number of occurrences of a given element in an array
// -----------------------------------------------------------------------
// Problem Statement:
// Given an array and a target element, count how many times the target appears.
//
// Example:
// arr = [1, 2, 3, 2, 4, 2], target = 2 → Output: 3
//
// Time Complexity:
// - Method 1 (Linear Search): O(n)
// - Method 2 (Using filter/count functions): O(n)
fun main(){
    val arr = arrayOf(1, 2, 3, 2, 4, 2, 5, 2)
    val target = 2

    // Method 1: Manual count using loop
    val countLoop = countOccurrencesLoop(arr, target)
    println("Method 1 (Loop): Element $target occurs $countLoop times")

    // Method 2: Count occurrences using Kotlin's built-in function
    // Method 2: Using Kotlin's built-in count function
    val countBuiltIn = countOccurrencesBuiltIn(arr, target)
    println("Method 2 (Built-in): Element $target occurs $countBuiltIn times")

}

fun countOccurrencesBuiltIn(arr:Array<Int>, target:Int): Int {
    return arr.count{
        it==target
    }
}

fun countOccurrencesLoop(arr:Array<kotlin.Int>, target:Int): Int {
    var count=0
    for (i in arr){
        if (i==target){
            count++
        }

    }
    return count
}
