package com.praroop.dsa.extensionfunction

fun main(){
    val message="PraroopTrivedi"
    println(message.lenght())
}
fun String.lenght(){
    if (this==null){
        println("string is null")
    }
    else{
        println("string is not null")


    }
}