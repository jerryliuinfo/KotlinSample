package com.apache.kotlin.offical

/**
 * Created by Jerry on 2020-05-30.
 */

val items = listOf(1, 2, 3, 4, 5)

// Lambdas 表达式是花括号括起来的代码块。
//items.fold(0, {
//    // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
//    acc: Int, i: Int ->
//    print("acc = $acc, i = $i, ")
//    val result = acc + i
//    println("result = $result")
//    // lambda 表达式中的最后一个表达式是返回值：
//    result
//})


fun main() {
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
    println(joinedToString)
}