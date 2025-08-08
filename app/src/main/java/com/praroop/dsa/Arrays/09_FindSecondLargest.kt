package com.praroop.dsa.Arrays

fun main(){
    val arr = arrayOf(10, 5, 20, 8, 15)

    // Method 1: Single pass without sorting
    val secondLargest1 = findSecondLargestSinglePass(arr)
    println("Method 1 (Single Pass): Second largest = $secondLargest1")


    // Method 2: Sort and pick second largest
    val secondLargest2 = findSecondLargestSorting(arr)
    println("Method 2 (Sorting): Second largest = $secondLargest2")

    // Method 3: Using built-in max and remove
    val secondLargest3 = findSecondLargestUsingBuiltIn(arr)
    println("Method 3 (Built-in): Second largest = $secondLargest3")

}

fun findSecondLargestSorting(array: Array<Int>): Int? {
    if (array.size<2)return null
    val sorted=array.sortedDescending()//// Sort in descending order
    println(sorted)
    return sorted.firstOrNull(){
        it!=sorted[0] // First element that is smaller than largest
    }
//    sorted[0] → This is the largest element (because we sorted in descending order).
//    it != sorted[0] → Skip the largest number(s).
//    firstOrNull { ... } → Give me the first number in the sorted list that is not equal to the largest one.
//    If all numbers are the same, it will return null.
}

fun findSecondLargestSinglePass(arr:Array<Int>): Int? {
    if (arr.size<2)return null

    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE

//    println("largest : ${largest}  secondLargest${secondLargest}")

  for (num in arr){
//      println("num : ${num}")
      if (num>largest){
          // When a new largest is found, the old largest becomes second largest
          secondLargest=largest
          largest=num
//          println("secondLargest : ${secondLargest}  largest${largest}")
      }else if (num > secondLargest && num != largest) {
          // If number is less than largest but greater than second largest
          secondLargest = num
//          println("secondLargest : ${secondLargest}")
      }

  }
    return if (secondLargest == Int.MIN_VALUE) null else secondLargest
}

// ------------------------------------------
// Method 3: Using built-in max and remove
// ------------------------------------------
fun findSecondLargestUsingBuiltIn(arr: Array<Int>): Int? {
    if (arr.size < 2) return null
    val maxVal = arr.maxOrNull()!!
    val filtered = arr.filter { it != maxVal } // Remove all largest elements
    return filtered.maxOrNull()
}