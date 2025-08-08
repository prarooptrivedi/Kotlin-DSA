package com.praroop.dsa.Arrays


// Linear Search implementation in Kotlin
// ---------------------------------------
// Definition: Linear search checks each element of the array until it finds the target.
// Works on both sorted and unsorted arrays.

fun main(){
val arr=arrayOf(10,20,30,40,50,50)
    val target=30
    //Mathod 1 for loop search
    val result=linearSearch(arr,target)
    if (result!= -1) {
        println("Method 1: Element $target found at index $result")
    } else {
        println("Method 1: Element $target not found")
    }

    // Method 2: While loop search
    val result2 = linearSearchUsingWhile(arr, target)
    if (result2 != -1) {
        println("Method 2: Element $target found at index $result2")
    } else {
        println("Method 2: Element $target not found")
    }
}

fun linearSearch(ints: Array<Int>, target: Int): Int{
    for (i in 0 until ints.size){
      if (ints[i]==target){
          return i // Return index if found
      }
    }
    return -1
}

fun linearSearchUsingWhile(arr: Array<Int>,target: Int): Int{
    // Method 2: Using while loop
    var index=0
    while (index < arr.size) {
        if (arr[index] == target) {
            return index
        }
        index++
    }

    return -1
}
