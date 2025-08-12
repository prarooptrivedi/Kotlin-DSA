package com.praroop.dsa.Arrays

// Program: Find Leaders in an Array
// ----------------------------------
// Problem Statement:
// A leader is an element that is greater than or equal to all elements to its right.
// The rightmost element is always a leader.
//
// Example:
// arr = [16, 17, 4, 3, 5, 2] → Leaders: 17, 5, 2
//
// Time Complexity:
// - Method 1 (Nested Loop): O(n^2)
// - Method 2 (Right-to-Left Traversal): O(n)

fun main(){
    val arr = arrayOf(16, 17, 4, 3, 5, 2)
    // Method 1: Using Nested Loop
    val leaders1 = findLeadersNestedLoop(arr)
    println("Method 1 (Nested Loop): Leaders are ${leaders1.joinToString()}")


    // Method 2: Using Right-to-Left Traversal (Efficient)
    val leaders2 = findLeadersEfficient(arr)
    println("Method 2 (Efficient): Leaders are ${leaders2.joinToString()}")
}


fun findLeadersNestedLoop(arr: Array<Int>): List<Int>{
    val leaders = mutableListOf<Int>()
    for (i in arr.indices) {
        var isLeader = true
        for (j in i + 1 until arr.size) {
            if (arr[j] > arr[i]) {
                isLeader = false
                break
            }
        }
        if (isLeader) leaders.add(arr[i])
    }
    return leaders
}

// Method 2: Traverse from right, keep track of max so far
fun findLeadersEfficient(arr: Array<Int>): List<Int> {
    val leaders = mutableListOf<Int>()
    var maxFromRight = arr.last()
    leaders.add(maxFromRight)

    for (i in arr.size - 2 downTo 0) {
        if (arr[i] >= maxFromRight) {
            maxFromRight = arr[i]
            leaders.add(maxFromRight)
        }
    }

    // Reverse to maintain left-to-right order
    leaders.reverse()
    return leaders
}
