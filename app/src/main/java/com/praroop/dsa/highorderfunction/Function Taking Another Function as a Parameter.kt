package com.praroop.dsa.highorderfunction

fun main(){
    val sum=calculate(5,4,::add)
    val multiply=calculate(5,4,::multiply)
    println("Print Valuev "+sum)
    println("Print Valuev "+multiply)
}

fun calculate(a: Int,b: Int,operation: (Int, Int) -> Int): Int{
    return operation(a,b)
}

fun add(x: Int,y: Int)=x+y
fun multiply(x: Int,y: Int)=x*y