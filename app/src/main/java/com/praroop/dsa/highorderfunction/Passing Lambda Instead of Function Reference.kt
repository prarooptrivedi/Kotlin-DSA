package com.praroop.dsa.highorderfunction

fun main(){
    val result=calculate1(4,6,){x,y->x*y}
    val result1=calculate1(4,6,){x,y->x-y}
    println("Resulet  "+result)
    println("Resulet  "+result1)
}
fun calculate1(a: Int,b: Int,operation:(Int, Int)-> Int): Int{
    return operation(a,b)
}