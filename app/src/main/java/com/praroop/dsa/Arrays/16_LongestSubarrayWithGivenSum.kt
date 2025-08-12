package com.praroop.dsa.Arrays

// Program: Longest Subarray with Given Sum
// -----------------------------------------
// Problem Statement:
// Given an array of integers and a target sum `k`,
// find the length of the longest subarray whose sum equals k.
//
// Example:
// arr = [10, 5, 2, 7, 1, 9], k = 15
// Output: 4
// Explanation: The subarray [5, 2, 7, 1] has sum 15 and length 4.
//
// Approach:
// - We use a HashMap to store (prefixSum -> firstIndex).
// - As we go through the array, we keep adding to prefixSum.
// - If prefixSum - k exists in the map, we found a subarray with sum k.
// - We track the maximum length.

fun main() {
    val arr = arrayOf(10, 5, 2, 7, 1, 9)
    val k = 15

    val maxLength = longestSubarrayWithSum(arr, k)
    println("Length of longest subarray with sum $k: $maxLength")
}

fun longestSubarrayWithSum(arr: Array<Int>, k: Int): Int {
    var prefixSum = 0                      // Holds sum of elements from start to current index
    var maxLength = 0                       // Stores the longest length found so far
    val sumIndexMap = mutableMapOf<Int, Int>() // Stores first occurrence of each prefix sum

    for (i in arr.indices) {
        prefixSum += arr[i] // Add current element to running sum

        // If sum itself equals k, update maxLength
        if (prefixSum == k) {
            maxLength = i + 1
        }

        // If prefixSum - k exists in map, we found a subarray with sum k
        if (sumIndexMap.containsKey(prefixSum - k)) {
            val length = i - sumIndexMap[prefixSum - k]!!
            if (length > maxLength) {
                maxLength = length
            }
        }

        // Store prefixSum in map if it's not already present
        // (We store only first occurrence to maximize subarray length)
        if (!sumIndexMap.containsKey(prefixSum)) {
            sumIndexMap[prefixSum] = i
        }
    }
    return maxLength
}
