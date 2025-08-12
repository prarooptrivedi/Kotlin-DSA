package com.praroop.dsa.Arrays


// File: 14_LeftRotateByD.kt
// ------------------------------------------
// Problem:
// Given an array, left rotate it by d places.
// That means each element shifts left by d positions and the first d elements move to the end
//
// Example:
// Input:  arr = [1, 2, 3, 4, 5], d = 2
// Output: [3, 4, 5, 1, 2]
//
fun main(){
    val orignalArr=intArrayOf(1,2,3,4,5,6)
    val d=2

    // Method 1: Using temp array (keeps code simple)
    val arr1 = orignalArr.copyOf()
    leftRotateUsingTemp(arr1, d)
    println("Left rotate by $d (temp): ${arr1.joinToString()}")

}
fun leftRotateUsingTemp(array: IntArray,d:Int){
    val n=array.size
    if (n==0) return

    // Step 1: Normalize d in case it's greater than array size
    val rotateBy = d % array.size // prevents unnecessary full rotations
    println("Rotate By ${rotateBy}")

    // Step 2: Slice the array
    // Take elements from index 'rotateBy' to end → This becomes the first part
    val firstPart = array.sliceArray(rotateBy until array.size)
    println("firstPart ${firstPart}")


}