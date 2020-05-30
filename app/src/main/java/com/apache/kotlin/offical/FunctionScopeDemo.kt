package com.apache.kotlin.offical

/**
 * Created by Jerry on 2020-05-30.
 */
fun main() {
    val startTime = System.currentTimeMillis()
    val x = findFixPoint()
    println("x:$x, cost time:${System.currentTimeMillis() - startTime} ms")

    val startTime2 = System.currentTimeMillis()
    val y = findFixPoint2()
    println("y:$y, cost time:${System.currentTimeMillis() - startTime2} ms")
}




fun <T> singletonList(item: T): List<T> {
    return arrayListOf(item)
}

val eps = 1E-10 // "good enough", could be 10^-15

/**
 * Kotlin 支持一种称为尾递归的函数式编程风格。 这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。
 * 当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本：
 */
tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))


private fun findFixPoint2(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (Math.abs(x - y) < eps) return x
        x = Math.cos(x)
    }
}