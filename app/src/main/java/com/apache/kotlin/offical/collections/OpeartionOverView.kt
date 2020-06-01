package com.apache.kotlin.offical.collections

/**
 * Created by Jerry on 2020-06-01.
 */
fun main() {

    val numbers = listOf("one", "two", "three", "four")
    val filterResults = mutableListOf<String>()  // 目标对象
    numbers.filterTo(filterResults) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
    println(filterResults) // 包含两个操作的结果

    val result = numbers.mapTo(HashSet()) { it.length }
    println("distinct item lengths are $result")


    val numbers2 = mutableListOf("one", "two", "three", "four")
    val sortedNumbers = numbers2.sorted()
    println("sorted numbers:$sortedNumbers")

    numbers2.sort()
    println("after sort::$sortedNumbers")



}