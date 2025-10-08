package com.praroop.dsa.highorderfunction

fun main(){
    val numbers=listOf(1,2,3,4,5,6,7,8,9)
    val doubled=numbers.map {
        it*2
    }
    val even=numbers.map {
        it%2==0
    }
    println(doubled)
    println(even)
}