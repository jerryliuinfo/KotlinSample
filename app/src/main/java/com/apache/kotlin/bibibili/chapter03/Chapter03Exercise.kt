package com.apache.kotlin.bibibili.chapter03

/**
 * author: jerry
 * created on: 2020/7/26 5:55 PM
 * description:
 */

private class Student constructor(val name:String, val age:Int, val gender:String){
    constructor(name:String, age:Int): this(name,age, "男")
    constructor(name:String): this(name,20)

    fun show(){
        println("$name, $age, $gender")
    }
}
fun main() {
    val stu = Student("jerry", 20, "女")
    stu.show()


    val array = intArrayOf(21, 40, 11, 33, 78)
    val filterResult = array.filter { it % 3 == 0  }
    println("filterResult:$filterResult")
}