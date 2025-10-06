package com.praroop.dsa.Strings

//Input: "swiss"
//Output: "w"

fun main(){
    println(firstNonReaptingChar("Hello"))
    println(firstNonReaptingChar("swiss"))

}

fun firstNonReaptingChar(value: String): Char?{
    // Create a mutable map to store frequency of each character
    // Key: character, Value: count of how many times it occurs
    val countMap=mutableMapOf<Char, Int>()
    // Loop through each character in the string
    for(ch in value){
        // getOrDefault(ch, 0) → returns the current count if exists, else 0
        // Add 1 to update the count for this character
        countMap[ch]=countMap.getOrDefault(ch,0)+1
    }
    // Loop through the string again, this time in original order
    for (ch in value) {
        // If the count of this character is 1, it is non-repeating
        if (countMap[ch] == 1) return ch
    }

    // If no character has count 1, return null (all characters repeat)
    return null
}