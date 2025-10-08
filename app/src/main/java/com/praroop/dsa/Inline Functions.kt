package com.praroop.dsa

import android.os.AsyncTask.execute

fun main(){
    executes{
        println("Running inlinefunction")
    }
}
inline fun executes(action:()-> Unit){
    action()
}