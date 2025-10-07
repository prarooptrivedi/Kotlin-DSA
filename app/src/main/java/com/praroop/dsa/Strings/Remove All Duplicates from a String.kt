package com.praroop.dsa.Strings

//Input: "banana"
//Output: "ban"
//
//Input: "programming"
//Output: "progamin"


fun main() {
    println(removeDuplicates("banana"))       // ban
    println(removeDuplicates("programming"))  // progamin
}

// Function to remove duplicate characters
fun removeDuplicates(str: String): String {
    val seen = mutableSetOf<Char>()   // Set to track seen characters
    val result = StringBuilder()      // StringBuilder to build result efficiently

    for (ch in str) {
        if (ch !in seen) {            // If character not seen before
            seen.add(ch)              // Mark as seen
            result.append(ch)         // Add to result
        }
    }

    return result.toString()          // Convert StringBuilder to String
}
