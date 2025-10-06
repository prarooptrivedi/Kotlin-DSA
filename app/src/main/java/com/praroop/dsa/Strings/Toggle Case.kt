package com.praroop.dsa.Strings


//Input: "KoTlIn123"
//Output: "kOtLiN123"
fun main(){
    println(toggelCase("KoTlIn123"))
    println(toggelCase("Hello World!"))
}

fun toggelCase(str: String): String{
    val result=StringBuilder()// // StringBuilder is efficient for building strings

    for(ch in str){
        when{
            ch.isLowerCase()->result.append(ch.uppercaseChar())
            ch.isUpperCase()->result.append(ch.lowercaseChar())
            else->result.append(ch)
        }
    }
    return result.toString()
}