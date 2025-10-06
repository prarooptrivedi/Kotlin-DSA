package com.praroop.dsa.Strings

fun main(){
    println(getLength("Hello"))
    println(getLength("Praroop Trivedi"))
}
fun getLength(value: String): Int{

    var count=0
    for (ch in value){
        count++
    }
    return count

}