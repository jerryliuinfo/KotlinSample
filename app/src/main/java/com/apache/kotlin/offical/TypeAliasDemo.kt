package com.apache.kotlin.offical

import org.w3c.dom.Node


/**
 * Created by Jerry on 2020-05-29.
 */
typealias NodeSet = Set<String>
typealias MyHandler = (Int, String, Any) -> Unit

 class AOut {
    inner class Inner{
         val name = "Hello"
    }
}
 class BOut {
    inner class Inner
}

typealias Predicate<T> = (T) -> Boolean

fun foo(p:Predicate<Int>) = p(42)


fun main() {
    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f))

    var p:Predicate<Int> = { it > 0}
    println(listOf(1,-2).filter(p))
}


