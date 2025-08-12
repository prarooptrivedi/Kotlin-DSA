package com.praroop.dsa

import kotlin.math.min

fun main(){
val arr= arrayOf(1,2,3,4,5,6,7)
   var n=arr.size

    var newArr=Array(n){0}

    for(i in arr.indices){
        newArr[i]=arr[n - 1 - i]
    }
    println("Reversed Arry ${newArr.joinToString()}")///=====ererererer
}