package com.praroop.dsa.Arrays

// Program: Build Array from Permutation
// --------------------------------------
// Problem Statement:
// Given a zero-based permutation array nums, build an array ans where:
// ans[i] = nums[nums[i]]
//
// Example:
// nums = [0, 2, 1, 5, 3, 4]
// Output: [0, 1, 2, 4, 5, 3]
// Explanation:
// ans[0] = nums[nums[0]] = nums[0] = 0
// ans[1] = nums[nums[1]] = nums[2] = 1
// ans[2] = nums[nums[2]] = nums[1] = 2
// ... and so on.
//
// Time Complexity: O(n)
// Space Complexity: O(n) for new array

fun main() {
    val nums = arrayOf(0, 2, 1, 5, 3, 4)
    val ans = buildArray(nums)
    println("Result: ${ans.joinToString()}")
}

fun buildArray(nums: Array<Int>): Array<Int> {
    val n = nums.size
    val ans = Array(n) { 0 } // Create new array of size n

    for (i in nums.indices) {
        ans[i] = nums[nums[i]] // Use permutation mapping
    }
    return ans
}
