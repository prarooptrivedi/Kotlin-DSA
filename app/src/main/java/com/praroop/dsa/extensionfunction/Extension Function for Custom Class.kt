package com.praroop.dsa.extensionfunction

fun main(){
    val p1= Persron("John",18)
    val p2= Persron("Praroop",16)
    println(p1.IsAdult())
}
class Persron(val name: String,val agr:Int)

fun Persron.IsAdult(): Boolean{

    return this.agr>=18
}