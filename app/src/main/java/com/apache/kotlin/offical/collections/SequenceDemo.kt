package com.apache.kotlin.offical.collections

/**
 * Created by Jerry on 2020-06-01.
 */
fun main() {

    val numbersSequence = sequenceOf("one","two","three")

    //如果已经有一个 Iterable 对象（例如 List 或 Set），则可以通过调用 asSequence() 从而创建一个序列

    val list = listOf("one", "two", "three", "four")
    val listToSequence = list.asSequence()

    /**
     *
     * 创建序列的另一种方法是通过使用计算其元素的函数来构建序列。
     * 要基于函数构建序列，请以该函数作为参数调用 generateSequence()。
     * （可选）可以将第一个元素指定为显式值或函数调用的结果。当提供的函数返回 null 时，序列生成停止。因此，以下示例中的序列是无限的
     */


    val oddNumbers = generateSequence(1) { it +2  }
    println(oddNumbers.take(5).toList())
    //println(oddNumbers.count()) //// 错误：此序列是无限的

    val oddNumbersLessThan10 = generateSequence(1) { if (it < 10) it + 2 else null }
    println(oddNumbersLessThan10.count())


    val oddNumbers2 = sequence {
        yield(1)
        yieldAll(listOf(2, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(oddNumbers2.take(5).toList())


    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = words.filter { print("filter: $it"); it.length > 3 }
        .map { print("map:length: ${it.length}"); it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)


    println()

    // 将列表转换为序列
    val wordsSequence = words.asSequence()

    val lengthsSequence = wordsSequence.filter { print("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    println("sequence Lengths of first 4 words longer than 3 chars")
// 末端操作：以列表形式获取结果。
    println(lengthsSequence.toList())

}
