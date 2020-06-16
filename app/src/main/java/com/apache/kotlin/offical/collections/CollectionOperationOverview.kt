package com.apache.kotlin.offical.collections

/**
 * Created by Jerry on 2020/6/8.
 */
fun main() {
    val numbers = listOf("one", "two", "three", "four")
    numbers.filter { it.length > 3 }  // `numbers` 没有任何改变，结果丢失
    println("numbers are still $numbers")


    val filterResults = mutableListOf<String>()  // 目标对象
    numbers.filterTo(filterResults) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
}