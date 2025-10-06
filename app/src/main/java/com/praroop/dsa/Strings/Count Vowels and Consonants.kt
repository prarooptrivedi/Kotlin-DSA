package com.praroop.dsa.Strings

import android.R

fun main() {
    println(findCountsAndVowelsAndConstant("Kotlin"))
}

fun findCountsAndVowelsAndConstant(value: String) {
    val vowle = "aeiouAeiou"
    var vowlecount = 0// Counter for vowels
    var ConstantCount = 0 // Counter for consonants

    // Loop through each character in the string
    for(ch in value){
        if (ch.isLetter()){// Check if character is a letter
            if (ch in vowle){ // If character is in vowels string
                vowlecount++
            }
            else{
                ConstantCount++
            }
        }
        // Print results

    }
    println("Vowels = $vowlecount, Consonants = $ConstantCount")
}