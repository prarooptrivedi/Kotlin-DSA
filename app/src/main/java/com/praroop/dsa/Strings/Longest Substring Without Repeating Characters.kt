package com.praroop.dsa.Strings

fun main() {
    println(lengthOfLongestUniqueSubstring("abcabcbb")) // 3
    println(lengthOfLongestUniqueSubstring("bbbbb"))    // 1
    println(lengthOfLongestUniqueSubstring("pwwkew"))   // 3
}

// Function to find length of longest substring without repeating characters
fun lengthOfLongestUniqueSubstring(str: String): Int {
    val set = mutableSetOf<Char>()   // Set to store unique characters
    var maxLength = 0                 // Maximum length
    var start = 0                     // Start pointer

    // Iterate through each character with end pointer
    for (end in str.indices) {
        // If character already in set, remove from start until it's removed
        while (str[end] in set) {
            set.remove(str[start])
            start++
        }

        // Add current character to set
        set.add(str[end])

        // Update max length
        maxLength = maxOf(maxLength, end - start + 1)
    }

    return maxLength
}
