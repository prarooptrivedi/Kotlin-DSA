package com.praroop.dsa.Arrays

// Program: Best Time to Buy and Sell Stock
// -----------------------------------------
// Problem Statement:
// You are given an array where each element represents the stock price on a given day.
// You can choose one day to buy and a later day to sell to maximize your profit.
// Return the maximum profit you can achieve. If no profit is possible, return 0.
//
// Example:
// prices = [7, 1, 5, 3, 6, 4]
// Output: 5
// Explanation:
// Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.
//
// Approach:
// 1. Track the minimum price so far.
// 2. For each price, calculate the profit if sold today: price - minPrice.
// 3. Update maxProfit whenever a better profit is found.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

fun main() {
    val prices = arrayOf(7, 1, 5, 3, 6, 4)
    val maxProfit = bestTimeToBuySell(prices)
    println("Maximum profit: $maxProfit")
}

fun bestTimeToBuySell(prices: Array<Int>): Int {
    var minPrice = Int.MAX_VALUE  // Keeps track of the lowest price seen so far
    var maxProfit = 0             // Stores the best profit found so far

    for (price in prices) {
        if (price < minPrice) {
            minPrice = price      // Update minimum price
        } else {
            val profit = price - minPrice // Profit if sold today
            if (profit > maxProfit) {
                maxProfit = profit // Update maximum profit
            }
        }
    }
    return maxProfit
}
