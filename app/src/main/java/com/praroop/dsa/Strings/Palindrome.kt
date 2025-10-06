package com.praroop.dsa.Strings

fun main(){
    println(checkPalinDrome("madam"))
    println(checkPalinDrome("kotlin"))
}
fun checkPalinDrome(value: String): Boolean{
    // Declare two variables for pointers

    var left=0 // Start from the first character
    var right=value.length-1 // Start from the last character
    // 'while' loop continues until left crosses right

    while (left<right){
        // Compare characters at left and right positions
        if (value[left]!=value[right]){
            // If any mismatch, it's not a palindrome
            return false

        }
        // Move left pointer one step right

        left++
        // Move left pointer one step right

        right--

    }
    return true

}