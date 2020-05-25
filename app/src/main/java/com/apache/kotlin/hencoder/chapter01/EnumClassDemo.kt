package com.apache.kotlin.hencoder.chapter01

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/**
 * Created by Jerry on 2020-05-25.
 * 每个枚举类型都是枚举class类的实例
 * 可以通过枚举类名.valueOf()来根据枚举名字获得枚举常量，当根据名字
 * 找不到枚举常量时，则会抛出异常
 *
 */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun main() {
    val north = Direction.valueOf("NORTH")
    println("north:$north")
    //println(Direction.values())
    //println(Direction.valueOf("test"))

   // printAllValues<Direction>()

}

enum class RGB { RED, GREEN, BLUE }

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


/**
 * 枚举常量也可以申明匿名匿名内部类
 */
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

/**
 * 枚举类可以实现一个接口（但不能从类派生），或者为所有条目提供单个接口成员实现，
 * 或者为匿名类中的每个条目提供单独的接口成员实现。这是通过将接口添加到枚举类声明中来完成的，
 */
/*
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}*/
