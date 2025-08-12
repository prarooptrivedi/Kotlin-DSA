package com.praroop.dsa.Arrays


// Program: Running Sum of 1D Array
// ---------------------------------
// Problem Statement:
// Given an array nums, return the running sum of nums.
// The running sum at index i is the sum of all elements from index 0 to i.
//
// Example:
// nums = [1, 2, 3, 4]
// Output: [1, 3, 6, 10]
// Explanation:
// runningSum[0] = 1
// runningSum[1] = 1 + 2 = 3
// runningSum[2] = 1 + 2 + 3 = 6
// runningSum[3] = 1 + 2 + 3 + 4 = 10
//
// Time Complexity: O(n)
// Space Complexity: O(1) if done in-place

fun main() {
    val nums = arrayOf(1, 2, 3, 4)
    val ans = runningSum(nums)
    println("Running Sum: ${ans.joinToString()}")
}

// Method 1: Create a new array
fun runningSum(nums: Array<Int>): Array<Int> {
    val result = Array(nums.size) { 0 }
    var sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        result[i] = sum
    }
    return result
}

// Method 2: In-place update
fun runningSumInPlace(nums: Array<Int>): Array<Int> {
    for (i in 1 until nums.size) {
        nums[i] += nums[i - 1]
    }
    return nums
}
