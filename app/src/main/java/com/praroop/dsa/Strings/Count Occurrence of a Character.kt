package com.praroop.dsa.Strings
//
//Input: ("Kotlin", 't')
//Output: 1

fun main(){
    println(countChar("Kotlimn",'m'))
}
fun countChar(value: String,element: Char): Int{
    var count=0
    for(ch in value){
        if (ch==element){
            count++

        }
    }
    return count
}