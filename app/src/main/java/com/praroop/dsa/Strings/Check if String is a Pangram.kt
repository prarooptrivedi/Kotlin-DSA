package com.praroop.dsa.Strings

//Input: "The quick brown fox jumps over the lazy dog"
//Output: true
//
//Input: "Hello World"
//Output: false

//A pangram is a sentence that contains all letters of the English alphabet (a to z) at least once.
//Example: "The quick brown fox jumps over the lazy dog" ✅
//Why? Because every letter from a to z appears at least once.
//Example: "Hello World" ❌
//Why? Letters like a, b, c, f, g, ... are missing.
fun main() {
    println(isPangram("The quick brown fox jumps over the lazy dog")) // true
    println(isPangram("Hello World"))                                 // false
}

// Function to check if string is a pangram
fun isPangram(str: String): Boolean {
    val lettersSeen = mutableSetOf<Char>()    // Set to store unique letters

    for (ch in str.lowercase()) {             // Convert string to lowercase
        if (ch in 'a'..'z') {                 // Only consider letters
            lettersSeen.add(ch)               // Add letter to set
        }
    }

    // If we have seen all 26 letters → pangram
    return lettersSeen.size == 26
}
