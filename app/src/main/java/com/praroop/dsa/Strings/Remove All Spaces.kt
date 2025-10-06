package com.praroop.dsa.Strings

fun main(){
    println(removeSpaceInString("Hello Wor    ld"))
}

fun removeSpaceInString(value: String): String{

    val result= StringBuilder() // Efficient for building strings
    for(ch in value){
        if (ch !=' '){
            result.append(ch)
        }
    }
    return result.toString()
}