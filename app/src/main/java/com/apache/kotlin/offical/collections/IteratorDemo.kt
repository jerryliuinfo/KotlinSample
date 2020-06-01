package com.apache.kotlin.offical.collections

/**
 * Created by Jerry on 2020-06-01.
 */
fun main() {


    testIterator()
    //遍历 Iterable 集合的另一种方法是众所周知的 for 循环。在集合中使用 for 循环时，将隐式获取迭代器。因此，以下代码与上面的示例等效
    testForEach()
    testSpecialIterator()
    testModifyableIterator()

}


private fun testIterator(){
    val list = listOf(1, 2, 3, 4)
    val iterator = list.iterator()
    while (iterator.hasNext()){
        print(iterator.next())
    }
    println()
}

private fun testForEach(){
    val list = listOf(1, 2, 3, 4)
    list.forEach {
        print(it)
    }
    println()

    for (item in list){
        print(item)
    }
}

private fun testSpecialIterator(){
    val list = listOf(1, 2, 3, 4)
    val listIterator = list.listIterator()
    while (listIterator.hasPrevious()){
        print("index:${listIterator.previousIndex()}, value:${listIterator.previous()}")
    }
    println()
}

/**
 * 为了迭代可变集合，于是有了 MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove() 。
 * 因此，可以在迭代时从集合中删除元素。
 */
private fun testModifyableIterator(){
    val list = mutableListOf(1, 2, 3, 4)
    val mutableIterator = list.listIterator()
    while (mutableIterator.hasNext()){
        val next = mutableIterator.next()
        if (next == 2){
            mutableIterator.add(10)
        }
        else if (next == 3){
            mutableIterator.remove()
        }

    }
    println("after removal:$list")
}
