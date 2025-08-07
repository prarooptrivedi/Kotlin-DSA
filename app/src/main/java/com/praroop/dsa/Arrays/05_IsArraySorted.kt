fun isSortedAscending(arr: Array<Int>): Boolean {
    // Traverse the array from index 1 to n - 1
    for (i in 1 until arr.size) {
        if (arr[i] < arr[i - 1]) {
            // If current element is less than previous, not sorted
            return false
        }
    }
    return true
}

fun isSortedDescending(arr: Array<Int>): Boolean {
    for (i in 1 until arr.size) {
        if (arr[i] > arr[i - 1]) {
            return false
        }
    }
    return true
}

fun isSorted(arr: Array<Int>): Boolean {
    // Check both ascending and descending
    return isSortedAscending(arr) || isSortedDescending(arr)
}

fun main() {
    val arr1 = arrayOf(1, 2, 3, 4, 5)
    val arr2 = arrayOf(9, 7, 5, 3, 1)
    val arr3 = arrayOf(1, 3, 2, 4)

    println("Array 1 is sorted: ${isSorted(arr1)}") // true
    println("Array 2 is sorted: ${isSorted(arr2)}") // true
    println("Array 3 is sorted: ${isSorted(arr3)}") // false
}
