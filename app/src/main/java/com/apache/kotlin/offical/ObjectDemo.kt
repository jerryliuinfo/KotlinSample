package com.apache.kotlin.offical

/**
 * Created by Jerry on 2020-05-25.
 * 有时要修改某类,但不改变原类并且不显式声明子类.
 * 对于这种情况,Java使用匿名内部类,
 * 而Kotlin使用:
 * 对象表达式(object expressions),
 * 对象声明(object declarations),
 * 伴生对象(companion object)
 */
open class A(x: Int) {
    open val y: Int = x
}

interface B { /*...*/ }

val ab: A = object : A(1), B {
    //override val y = 15
}

fun main() {
    println(ab.y)
}