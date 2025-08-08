package com.praroop.dsa.Arrays

// Move all zeros to the end of the array
// --------------------------------------
// Problem: Given an array, move all zeros to the end while keeping the order of non-zero elements.
// Example:
// Input:  [0, 1, 0, 3, 12]
// Output: [1, 3, 12, 0, 0]
fun main(){
    val arr = arrayOf(0, 1, 0, 3, 12)

    moveZerosInPlace(arr)

    println("Array after moving zeros: ${arr.joinToString()}")
}

fun moveZerosInPlace(arr: Array<Int>) {
    var index=0
    // Step 1: Loop through array and move all non-zero numbers to the front
    for (num in arr) {
        if (num != 0) {           // Found a non-zero number
            arr[index] = num      // Place it at the current 'index' position
            index++               // Move 'index' to the next position
        }
    }
    // Step 2: Fill the remaining positions in the array with zeros
    while (index < arr.size) {
        arr[index] = 0            // Assign zero to the position
        index++                   // Move to next position
    }

}
