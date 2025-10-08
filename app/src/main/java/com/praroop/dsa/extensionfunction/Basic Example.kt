package com.praroop.dsa.extensionfunction
//// Define an extension function for the String class
fun main(){
    val message="Hello"
    println(message.addNewString())
}

fun String.addNewString(): String{
    return this+"Praroop"
}