package com.praroop.dsa.Strings

//Input: "Hello World from Kotlin"
//Output: 4


fun main(){
    println(countStringWord("Hello World from Kotlin A"))
}

fun countStringWord(string: String) : Int{
    // Trim leading/trailing spaces and split by spaces
    val words=string.trim().split(" ")

    val count=words.filter {
        it.isNotEmpty()
    }.size
    return count
}
