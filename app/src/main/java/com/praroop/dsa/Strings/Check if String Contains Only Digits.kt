package com.praroop.dsa.Strings

//Input: "12345"
//Output: true
//
//Input: "12a45"
//Output: false


fun main(){
    println(checkString("12345"))
    println(checkString("12a45"))
    println(checkString("9870"))
}

fun checkString(string: String): Boolean {
    for (ch in string){
        if (!ch.isDigit()){
            return false
        }
    }
    return true

}
