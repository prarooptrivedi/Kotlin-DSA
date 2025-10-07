package com.praroop.dsa.Strings

//Input: "listen", "silent"
//Output: true
//
//Input: "hello", "bello"
//Output: false

fun main(){
    println(checkAnaGram("listen", "silent"))
    println(checkAnaGram("hello", "bello"))   // false

}


fun checkAnaGram(value: String,value1: String): Boolean{
    if (value.length!=value1.length){
        return false
    }
    // Create frequency maps for both strings
//    A frequency map is a table that counts how many times each character appears in a string.
//    mutableMapOf<Char, Int>() → a map where:
//    Key = the character (like 'a', 'b')
//    Value = number of times it appears
    val freq1=mutableMapOf<Char, Int>()
    val freq2=mutableMapOf<Char, Int>()
    for (ch in value){
//        for (ch in str1) → loop through each character in str1.
//        freq1.getOrDefault(ch, 0) → get the current count of ch, or 0 if it’s not in the map yet.
//        + 1 → increase the count by 1.
//        Example for "listen":
//        freq1[ch]=freq1.getOrDefault(ch,0)+1
    }
    for (ch in value1){
        freq2[ch]=freq2.getOrDefault(ch,0)+1
    }
    // Compare the two maps
    return freq1 == freq2
}