package com.praroop.dsa.Strings

//Input: "Hello", "Hello"
//Output: true

fun main() {
    println(compareTwoStrting("Hello", "Hello"))
    println(compareTwoStrting("Hello", "Hello0"))
    println(compareTwoStrting("Hello", "Praro"))


}

fun compareTwoStrting(fstring: String, sstring: String): Boolean {

    if (fstring.length!=sstring.length){
        return false
    }
    for (i in fstring.indices){
        if (fstring[i]!=sstring[i]){
            return false
        }
    }
    return true

}