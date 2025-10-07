package com.praroop.dsa.Strings

fun main(){
    // Call the function with the string "programming"
    // This will find all duplicate characters in the string
    println(findDuplicateChar("programming"))
}

// Function to find duplicate characters in a string
fun findDuplicateChar(string: String) {
    // Create a mutable map to store frequency of each character
    // Key = character, Value = number of times it appears
    val freqMap = mutableMapOf<Char, Int>()

    // Loop through each character in the string
    for (ch in string) {
        // Get current count of character 'ch' in map
        // If not present, default is 0, then add 1
        freqMap[ch] = freqMap.getOrDefault(ch, 0) + 1
    }

    // Print a heading for duplicate characters
    println("Duplicate characters:")

    // Loop through all entries (key-value pairs) in the frequency map
    for ((ch, count) in freqMap) {
        // Check if the character appears more than once
        if (count > 1) {
            // Print the duplicate character
            println("$ch") // You can also print count if needed: "$ch -> $count"
        }
    }
}
