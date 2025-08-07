package com.praroop.dsa.Arrays

fun main(){
    val array= arrayOf(10,20,30,40,50,60)
    println("Array Element Are")
    for (element in array){
        println(element)
    }
    println("Array Element Using ForEach")

    array.forEach {element->
        println(element)

    }

    println("\n\nArray Element joinToString()")
    println(array.joinToString(" "))
}