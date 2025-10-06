package com.praroop.dsa.Strings

//Input: "hello"
//Output: "olleh"
//
//Input: "Kotlin"
//Output: "niltok"

fun main(){
    println(reverseString("hello"))
    println(reverseString("Kotlin"))
}
fun reverseString(value: String): String{
    // Convert the input string into a CharArray so we can modify individual characters
    val chars=value.toCharArray()
    // Declare two integer variables (indexes) to point to the start and end of the array
    var left=0
    var right=chars.size-1//// 'size' gives the total number of elements in the array
    // 'while' loop runs as long as 'left' index is smaller than 'right'
    while (left< right){
        // Store the left character temporarily
        val temp = chars[left]
        // Swap left and right characters
        chars[left]=chars[right]
        chars[right]=temp
        // Move 'left' pointer one step to the right
        left++

        // Move 'right' pointer one step to the left
        right--


    }
    // Convert the modified character array back to a String and return it
    return String(chars)
}