package com.apache.kotlin.offical

import kotlin.properties.Delegates

/**
 * Created by Jerry on 2020-05-29.
 */

class Example {
}

/**
 * azy() 是接受一个 lambda 并返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托：
 * 第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果，
 * 后续调用 get() 只是返回记录的结果。
 */
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}



class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
    var world: String by Delegates.observable("<no name>") {
            prop, old, new ->
        println("$prop:$old -> $new")
    }
}

class User2(val map: MutableMap<String, Any?>) {
    val name: String by map
    val age: Int     by map

}
fun main() {
    println(lazyValue)
    println(lazyValue)

    val user = User(mapOf("name" to "Jerry", "age" to 25))
    user.world = "first"
    user.world = "second"

    println("${user.name}:${user.age}")

    val user2 = User2(mutableMapOf("name" to "John", "age" to 20))
    println("${user2.name}:${user2.age}")


}