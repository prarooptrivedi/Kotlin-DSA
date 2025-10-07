package com.praroop.dsa.Strings

//Input: str1 = "ABCD", str2 = "CDAB"
//Output: true
//
//Input: str1 = "ABCD", str2 = "ACBD"
//Output: false


fun main() {
    println(areRotations("ABCD", "CDAB")) // true
    println(areRotations("ABCD", "ACBD")) // false
}

// Function to check if two strings are rotations of each other
fun areRotations(str1: String, str2: String): Boolean {
    // If lengths differ → cannot be rotations
    if (str1.length != str2.length) return false

    // Concatenate str1 with itself
    val combined = str1 + str1

    // Check if str2 is a substring of combined
    return combined.contains(str2)
}