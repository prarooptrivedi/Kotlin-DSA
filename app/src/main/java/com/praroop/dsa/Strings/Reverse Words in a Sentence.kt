package com.praroop.dsa.Strings

//Input: "Hello World from Kotlin"
//Output: "Kotlin from World Hello"

fun main(){
    println(reverseWord("Hello World from Kotlin"))
}

fun reverseWord(value: String): String{
    val words=value.split(" ")
    val reversedString=words.reversed()
    return  reversedString.joinToString(" ")
}