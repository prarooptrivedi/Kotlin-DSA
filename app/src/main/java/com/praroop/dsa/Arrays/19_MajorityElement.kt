package com.praroop.dsa.Arrays

// Program: Majority Element (> n/2 times)
// ----------------------------------------
// Problem Statement:
// Given an array, find the element that appears more than n/2 times.
// If no such element exists, return -1.
//
// Example:
// arr = [2, 2, 1, 1, 1, 2, 2]
// Output: 2
// Explanation: Element 2 appears 4 times in an array of length 7 (4 > 7/2).
//
// Approach:
// Method 1: Brute Force - Count frequency of each element using nested loops. (O(n²))
// Method 2: Boyer-Moore Voting Algorithm - O(n) time, O(1) space.

fun main() {
    val arr = arrayOf(2, 2, 1, 1, 1, 2, 2)

    val majority1 = majorityElementBruteForce(arr)
    println("Method 1 (Brute Force): Majority Element = $majority1")

    val majority2 = majorityElementBoyerMoore(arr)
    println("Method 2 (Boyer–Moore): Majority Element = $majority2")
}

// Method 1: Brute Force O(n²)
fun majorityElementBruteForce(arr: Array<Int>): Int {
    val n = arr.size
    for (i in arr.indices) {
        var count = 0
        for (j in arr.indices) {
            if (arr[j] == arr[i]) count++
        }
        if (count > n / 2) return arr[i]
    }
    return -1 // No majority element
}

// Method 2: Boyer–Moore Voting Algorithm O(n)
fun majorityElementBoyerMoore(arr: Array<Int>): Int {
    var count = 0
    var candidate = -1

    // Step 1: Find candidate
    for (num in arr) {
        if (count == 0) {
            candidate = num
            count = 1
        } else if (num == candidate) {
            count++
        } else {
            count--
        }
    }

    // Step 2: Verify candidate
    var occurrence = 0
    for (num in arr) {
        if (num == candidate) occurrence++
    }
    return if (occurrence > arr.size / 2) candidate else -1
}
