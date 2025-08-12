package com.praroop.dsa.Arrays

// Program: Maximum Subarray Sum (Kadane's Algorithm)
// ---------------------------------------------------
// Problem Statement:
// Given an integer array, find the contiguous subarray with the largest sum.
// Return the sum.
//
// Example:
// arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
// Output: 6
// Explanation: Subarray [4, -1, 2, 1] has the largest sum = 6.
//
// Kadane’s Algorithm Logic:
// 1. Keep a running sum of the subarray (currentSum).
// 2. If currentSum becomes negative, reset it to 0 (start a new subarray).
// 3. Keep track of the maximum sum found so far (maxSum).
//
// Time Complexity: O(n)
// Space Complexity: O(1)

fun main() {
    val arr = arrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val maxSum = kadaneMaxSubarraySum(arr)
    println("Maximum subarray sum: $maxSum")
}

fun kadaneMaxSubarraySum(arr: Array<Int>): Int {
    var currentSum = 0          // Running sum of current subarray
    var maxSum = Int.MIN_VALUE  // Tracks maximum sum found so far

    for (num in arr) {
        currentSum += num       // Add current element to running sum

        if (currentSum > maxSum) {
            maxSum = currentSum // Update maxSum if currentSum is greater
        }

        if (currentSum < 0) {
            currentSum = 0      // Reset if sum becomes negative
        }
    }
    return maxSum
}