package com.apache.kotlin.offical.collections

/**
 * Created by Jerry on 2020-05-30.
 */
fun main() {

    val numbers = mutableListOf("one", "two", "three", "four")
    numbers.add("five")   // 这是可以的
    println(numbers)
//numbers = mutableListOf("six", "seven")      // 编译错误

    val list:List<Shape> = mutableListOf(Shape())

    var stringList = listOf("one","two","three","two")
    printAll(stringList)

    var stringSet = setOf("one","two","three","two")
    printAll(stringSet)



    val words = "A long time ago in a galaxy far far away".split(" ")
    println(words)
    val shortWords = mutableListOf<String>()
    words.getShortWordsTo(shortWords, 3)
    println(shortWords)

}

fun List<String>.getShortWordsTo(shortWords: MutableList<String>, maxLength: Int) {
    this.filterTo(shortWords) { it.length <= maxLength }
    // throwing away the articles
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles
}

fun printAll(strings: Collection<String>) {
    for(s in strings) print("$s ")
    println()
}

open class Shape

class Rectangle: Shape()