package com.praroop.dsa.Arrays

fun main() {
    val arr = arrayOf(10, 20, 30, 40, 50, 60)

    reverseInPlace(arr)
    val arr1 = arrayOf(10, 20, 30, 40, 50, 60)
    reverseWithBuiltIn(arr1)

    val arr2 = arrayOf(10, 20, 30, 40, 50, 60)
    reverseByCopying(arr2)
}

fun reverseInPlace(arr: Array<Int>) {
    var start = 0
    var end = arr.size - 1

    // Loop until two pointers meet in the middle
    while (start < end) {
        // Swap elements at start and end
        val temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp

        start++
        end--
    }

    println("Method 1: In-place reversed array: ${arr.joinToString()}")
}

fun reverseWithBuiltIn(arr:Array<Int>){
    val reversed=arr.reversed()
    println("Method 2: Built-in reversed array: ${reversed.joinToString()}")
}

fun reverseByCopying(arr: Array<Int>){
    // Step 1: Get size of input array
    val n =arr.size
    // Step 2: Create a new array of same size filled with zeros
    val reversed = Array(n) { 0 }

    // Step 3: Loop over the original array
    // and copy elements from the end to the start of the new array
    for (i in arr.indices) {
        reversed[i] = arr[n - 1 - i]
        // Example: i=0 -> reversed[0] = arr[4], i=1 -> reversed[1] = arr[3], ...
    }
    // Step 4: Print the new reversed array
    println("Method 3: Reverse by copying: ${reversed.joinToString()}")

}