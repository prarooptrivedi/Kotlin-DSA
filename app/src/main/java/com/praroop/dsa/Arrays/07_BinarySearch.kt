package com.praroop.dsa.Arrays

// Binary Search implementation in Kotlin
// ---------------------------------------
// Definition: Binary Search works by dividing the array into halves until the target is found.
// Requirement: The array must be sorted in ascending order for this implementation
//Why Binary Search is Fast
//Suppose you have 1,000,000 numbers sorted in a list.
//Linear Search might take up to 1,000,000 checks.
//Binary Search will find the number in only ~20 checks because:
//After 1 check → 500,000 left
//After 2 checks → 250,000 left
//After 20 checks → only 1 number left.
fun main(){
    val arr = arrayOf(10, 20, 30, 40, 50, 60, 70)
    val target = 50

    // Method 1: Iterative approach
    val resultIterative = binarySearchIterative(arr, target)
    if (resultIterative != -1) {
        println("Method 1 (Iterative): Element $target found at index $resultIterative")
    } else {
        println("Method 1 (Iterative): Element $target not found")
    }

    // Method 2: Using For approach
    val resultIterative1 = binarySearchForLoop(arr, target)
    if (resultIterative1 != -1) {
        println("Method 1 (Iterative): Element $target found at index $resultIterative1")
    } else {
        println("Method 1 (Iterative): Element $target not found")
    }

}

fun binarySearchIterative(arr:Array<Int>, target:Int): Int {

    var left=0  // Start index
    var right=arr.size-1 // End index

    while (left<=right){
        // Find the middle index
        val mid=left+(right-left)/2
        // Step 1: Check if middle element is the target

        if (arr[mid]==target){
            return mid
        }
        // Step 2: If target is bigger, search the right half
        else if (arr[mid]<target){
            left=mid+1
        }
        // Step 3: If target is smaller, search the left half
        else {
            right = mid - 1
        }

    }


    return -1

}

fun binarySearchForLoop(arr: Array<Int>,target: Int):Int{

    var left=0
    var right=arr.size-1
    println("Left${left}+right${right}")
    for (i in arr.indices){

        if (left > right) break
        val mid = left + (right - left) / 2
        println("Mid${mid}")
        if (arr[mid] == target) {
            return mid
        } else if (arr[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1

}