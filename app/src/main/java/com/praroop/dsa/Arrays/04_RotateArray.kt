package com.praroop.dsa.Arrays

import androidx.collection.ObjectList

fun main() {

    val arr = mutableListOf(10, 20, 30, 33, 45, 56, 555)
//    🔁 Rotate array left by 1
//
//    🔁 Rotate array right by 1
//
//    🔁 Rotate array left by k
//
//    🔁 Rotate array right by k


    val original = arrayOf(1, 2, 3, 4, 5)
    rotateLeftByOne(original.copyOf())
    rotateRightByOne(original.copyOf())
    rotateLeftByK(original.copyOf(),3)
    rotateRightByK(original.copyOf(),3)
}

fun rotateRightByK(arr: Array<Int>, k: Int) :Array<Int>{

    val n =arr.size

    val result=Array(n){0}

    for (i in 0 until n){
        result[(i + k) % n] = arr[i]
    }
    println("Right Rotate by $k: ${result.joinToString()}")
    return result
}


fun rotateLeftByOne(arr: Array<Int>): Array<Int> {

    if (arr.isEmpty()) return arr

    // Save the first element
    val first = arr[0]

    // Shift all elements to the left by one
    for (i in 1 until arr.size) {
        arr[i - 1] = arr[i]
    }

    // Put the first element at the end
    arr[arr.size - 1] = first
    println("Left Rotate by 1: ${arr.joinToString()}")
    return arr
}

fun rotateRightByOne(arr: Array<Int>): Array<Int> {
    if (arr.isEmpty()) return arr

    // Save the last element
    val last = arr[arr.size - 1]

    // Shift all elements to the right by one
    for (i in arr.size - 2 downTo 0) {
        arr[i + 1] = arr[i]
    }

    // Put the last element at the start
    arr[0] = last
    println("Right Rotate by 1: ${arr.joinToString()}")
    return arr


}
fun rotateLeftByK(arr: Array<Int>, k: Int): Array<Int>  {

    val n =arr.size

    val result=Array(n){0}

    for (i in 0 until n){
        // Place element at (i + n - k) % n to rotate left
        result[i] = arr[(i + k) % n]
    }
    println("Left Rotate by $k: ${result.joinToString()}")
    return result
}