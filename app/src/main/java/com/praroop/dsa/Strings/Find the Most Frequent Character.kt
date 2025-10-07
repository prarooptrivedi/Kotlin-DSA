package com.praroop.dsa.Strings

//Input: "programming"
//Output: g (appears 2 times)


fun main(){
    println(mostFreqChar("programming"))
    println(mostFreqChar("hello world")) // l

}

fun mostFreqChar(string: String): Char? {
    val freqMap=mutableMapOf<Char, Int>()
    for(ch in string){
        freqMap[ch]=freqMap.getOrDefault(ch,0)+1

    }
    var maxChar:Char?=null
    var maxCount=0
    // Find character with maximum frequency
    for ((ch, count) in freqMap) {
        if (count > maxCount) {
            maxCount = count
            maxChar = ch
        }
    }

    return maxChar
}
