package com.praroop.dsa.Arrays
// Remove all elements that have duplicates
// -----------------------------------------
// Problem: Given a sorted array, remove all elements that occur more than once
// Example:
// Input:  [1, 1, 2, 3, 3, 4, 5, 5]
// Output: [2, 4]

fun main(){
    val arr = arrayOf(1, 1, 2, 3, 3, 4, 5, 5)



    println("Method 1 (Normal for-loop): ${removeAllDuplicatesNormal(arr).joinToString()}")
    println("Method 2 (Predefined functions): ${removeAllDuplicatesPredefined(arr).joinToString()}")
}

fun removeAllDuplicatesNormal(arr: Array<Int>): Array<Int>{
    val result = mutableListOf<Int>()
    for (i in arr.indices){
        var count=0
        for (j in arr.indices){
            if (arr[i]==arr[j]){
                count++
            }
        }
        if (count==1){// // Keep only unique elements
            result.add(arr[i])
        }
    }
    return result.toTypedArray()
}


// ------------------------------------------
// Method 2: Using Predefined Kotlin Functions
// ------------------------------------------
fun removeAllDuplicatesPredefined(arr: Array<Int>): Array<Int> {
    return arr.filter { num -> arr.count { it == num } == 1 }.toTypedArray()
}