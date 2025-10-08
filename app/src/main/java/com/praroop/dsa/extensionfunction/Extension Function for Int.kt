package com.praroop.dsa.extensionfunction

fun main(){
    val number=5
    println(number.add())
}
fun Int.add(): Int{
    return this+1
}