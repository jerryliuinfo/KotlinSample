package com.apache.kotlin.offical.collections

/**
 * Created by Jerry on 2020-06-01.
 */
fun main() {
    testRange()
    testRangeDownTo()
}

/**
 * Kotlin 可通过调用 kotlin.ranges 包中的 rangeTo() 函数及其操作符形式的 ..
 * 轻松地创建两个值的区间。 通常，rangeTo() 会辅以 in 或 !in 函数。
 */
private fun testRange(){
    println("range")
    for (i in 1..4) {
        print(i)
    }
    println()
}

private fun testRangeDownTo(){
    println("downTo")

    for (i in 4 downTo 1 ) {
        print(i)
    }
    println()

    //也可以通过任意步长（不一定为 1 ）迭代数字。 这是通过 step 函数完成的
    for (i in 8 downTo 1 step 2 ){
        print(i)
    }
    println()

    //要迭代不包含其结束元素的数字区间，请使用 until 函数：
    for (i in 1 until 10 step 2 ){
        print(i)
    }
    println()
    //要创建反向迭代的数列，请在定义其区间时使用 downTo 而不是 ..
    for (i in 5 downTo 1) {
        print(i)
    }
}