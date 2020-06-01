package com.apache.kotlin.offical.collections

import java.util.*
import kotlin.collections.HashSet

/**
 * Created by Jerry on 2020-05-30.
 */
fun main() {

    val emptySet = mutableSetOf<String>()

    //同样的，Map 也有这样的函数 mapOf() 与 mutableMapOf()。映射的键和值作为 Pair 对象传递（通常使用中缀函数 to 创建
    /**
     * 注意，to 符号创建了一个短时存活的 Pair 对象，因此建议仅在性能不重要时才使用它。
     * 为避免过多的内存使用，请使用其他方法。例如，可以创建可写 Map 并使用写入操作填充它。 apply() 函数可以帮助保持初始化流畅。
     */
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    println(numbersMap)


    var numbersMap2 = mutableMapOf<String,String>().apply {
        this["one"] = "1"
        this["two"] = "2"
    }
    println(numbersMap2)

    //空集合
    val  emptyList = emptyList<String>()



    //list 的初始化函数
    var doubled = List(3, { it * 3 })
    println(doubled)


    //具体类型构造函数
    val linkedList = LinkedList(listOf("one","two", "three"))
    val presizeSet = HashSet<Int>(32)
    println("linkedList:$linkedList, presizeSet:$presizeSet")


    //copy
    val sourceList = mutableListOf(1,2,3)
    val copyList = sourceList.toMutableList()
    val readOnlyCopyList = sourceList.toList()
    sourceList.add(4)
    println("source size:${sourceList.size}, copyList:${copyList.size}")

    //这些函数还可用于将集合转换为其他类型，例如根据 List 构建 Set，反之亦然。
    val copySet = sourceList.toMutableSet()
    copySet.add(3)
    copySet.add(4)
    println(copySet)

    //或者，可以创建对同一集合实例的新引用。使用现有集合初始化集合变量时，将创建新引用。 因此，当通过引用更改集合实例时，更改将反映在其所有引用中。

    val referenceList = sourceList
    referenceList.add(5)
    println("referenceList size:${referenceList.size}, sourceList size:${sourceList.size}")

    //调用其他集合的函数
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    val numbers2 = listOf(1,3,5)

    //映射生成转换结果列表
    println(numbers2.map { it * 3 })
    println(numbers2.mapIndexed { idx, value -> value * idx })
    println(numbers2.mapIndexed { idx, value -> value * idx })


    //关联生成 Map

    val numbers3 = listOf("one", "two", "three", "four")
    println(numbers3.associateWith { it.length })
}