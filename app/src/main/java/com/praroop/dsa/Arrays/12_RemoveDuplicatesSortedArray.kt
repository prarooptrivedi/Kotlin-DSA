package com.praroop.dsa.Arrays

import android.R


// Remove duplicates from a sorted array
// --------------------------------------
// Problem: Given a sorted array, remove duplicate elements in-place
//          so that each element appears only once. The relative order should be maintained.
// Note: We will not create a new array, just modify the existing one.
// Example:
// Input:  [1, 1, 2, 2, 3, 4, 4]
// Output: [1, 2, 3, 4, _, _, _, _] (underscores mean old values that are ignored
fun main(){

    val arr=arrayOf(1,2,3,4,3,2,5,6,3,2,1)

    val newLength=removeDuplicates(arr)
    println("Array after removing duplicates: ${arr.sliceArray(0 until newLength).joinToString()}")
    println("New length: $newLength")

}

fun removeDuplicates(arr: Array<Int>): Int {
    // If array is empty or has one element, no duplicates exist
    if (arr.isEmpty()) return 0
    if (arr.size == 1) return 1

    var index = 0 // Points to last unique element

    // Step 1: Loop through array starting from index 1
    for (i in 1 until arr.size) {
        // Step 2: If current element is different from the last unique element
        if (arr[i] != arr[index]) {
            index++            // Move index forward
            arr[index] = arr[i] // Replace with new unique element
        }
    }

    // Step 3: Return the count of unique elements
    return index + 1
}

//🧠 Logic Explanation
//Since the array is sorted, all duplicates are grouped together.
//
//We use index to track where the last unique element was placed.
//
//Every time we find a different element, we move index forward and overwrite the duplicate.
//
//At the end, index + 1 is the number of unique elements.
