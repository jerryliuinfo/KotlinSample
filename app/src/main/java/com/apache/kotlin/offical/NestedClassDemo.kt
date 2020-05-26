package com.apache.kotlin.offical

import android.view.Window

/**
 * Created by Jerry on 2020-05-25.
 *
 * 标记为inner的嵌套类可以访问其外部类的成员。内部类带有对外部类对象的引用：
 */
class Outer {
    private val bar: Int = 1
    inner class Nested {
        fun foo() = 2

        fun eat() = bar
    }

}

val demo = Outer().Nested().foo() // == 2
fun main() {
    println(demo)
    println(Outer().Nested().eat())

    val window:Window
    
}

