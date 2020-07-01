package com.apache.kotlin.offical.collections

/**
 * author: jerry
 * created on: 2020/6/17 1:20 PM
 * description:
 */

fun main() {

    testMap()

    println("begin testMapNotNull")

    testMapNotNull()

    println("begin testMapKeysAndMapValues")
    testMapKeysAndMapValues()

}

/**
 * 映射 转换从另一个集合的元素上的函数结果创建一个集合。 基本的映射函数是 map()。
 * 它将给定的 lambda 函数应用于每个后续元素，并返回 lambda 结果列表。 结果的顺序与元素的原始顺序相同。
 * 如需应用还要用到元素索引作为参数的转换，请使用 mapIndexed()
 */
fun testMap(){
    val numbers = setOf(1,2,3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { index, i -> if (index == 1){
        println("index: 1 set value to 10")
        10 }
    else {index * i}
    })

}

/**
 * 如果转换在某些元素上产生 null 值，则可以通过调用 mapNotNull() 函数取代
 * map() 或 mapIndexedNotNull() 取代 mapIndexed() 来从结果集中过滤掉 null 值
 */
fun testMapNotNull(){
    val numbers = setOf(1,2,3)
    println(numbers.mapNotNull { if (it == 2) null else  it * 3})
    println(numbers.mapIndexedNotNull { index, i -> if (index == 1) null else i * index  })

}


/**
 * 映射转换时，有两个选择：转换键，使值保持不变，反之亦然。
 * 要将指定转换应用于键，请使用 mapKeys()；反过来，mapValues() 转换值。
 * 这两个函数都使用将映射条目作为参数的转换，因此可以操作其键与值
 */
fun testMapKeysAndMapValues(){
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })
}

/**
 * 双路合并 转换是根据两个集合中具有相同位置的元素构建配对。 在 Kotlin 标准库中，这是通过 zip() 扩展函数完成的。
 * 在一个集合（或数组）上以另一个集合（或数组）作为参数调用时，zip() 返回 Pair 对象的列表（List）。 接收者集合的元素是这些配对中的第一个元素。
 * 如果集合的大小不同，则 zip() 的结果为较小集合的大小；结果中不包含较大集合的后续元素。 zip() 也可以中缀形式调用 a zip b 。
 */
