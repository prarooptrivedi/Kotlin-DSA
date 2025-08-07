package com.praroop.dsa.Arrays

fun main() {
    val arr= arrayOf(10,20,30,40,55,43,22,44,55)


    // Initialize max with smallest integer and min with largest integer
    var max=Int.MIN_VALUE
    var min=Int.MAX_VALUE

    // Loop through the array to compare each element
    for (num in arr){
         if (num>max) max = num // Update max if current element is greater
         if (num<min) min=num// Update min if current element is smaller
     }
    println("Method 1: Loop Based")
    println("Maximum value: $max")
    println("Minimum value: $min")


    // Kotlin provides built-in functions to get max and min from an array
    val maxi= arr.maxOrNull()
    val  mini=arr.minOrNull()

    println("Method 2: Using maxOrNull() and minOrNull()")
    println("Maximum: $max")
    println("Minimum: $min")

    handleEmptyArray(arr)
    usingCollections(arr)

}

fun handleEmptyArray(arr: Array<Int>) {
    if (arr.isEmpty()) {
        println("Array is empty. Cannot find min/max.")
        return
    }

    val max = arr.maxOrNull()
    val min = arr.minOrNull()

    println("Handled Empty Case")
    println("Max: $max")
    println("Min: $min")
}

fun usingCollections(arr:Array<Int>) {

    val list = arr.toList()  // Convert array to List to use Java's Collections
    val max = java.util.Collections.max(list)
    val min = java.util.Collections.min(list)

    println("Method 4: Using Java Collections")
    println("Maximum: $max")
    println("Minimum: $min")
}
