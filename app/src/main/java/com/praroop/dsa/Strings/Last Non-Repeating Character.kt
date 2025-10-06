package com.praroop.dsa.Strings

fun lastNonRepeatingChar(str: String): Char? {
    val countMap = mutableMapOf<Char, Int>()

    for (ch in str) {
        countMap[ch] = countMap.getOrDefault(ch, 0) + 1
    }

    // Iterate from end to start
    for (i in str.length - 1 downTo 0) {
        if (countMap[str[i]] == 1) return str[i]
    }

    return null
}

fun main() {
    println(lastNonRepeatingChar("swiss")) // i
    println(lastNonRepeatingChar("aabb"))  // null
}
