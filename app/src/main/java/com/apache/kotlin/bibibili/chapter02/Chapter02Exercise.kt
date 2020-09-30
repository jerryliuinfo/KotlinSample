package com.apache.kotlin.bibibili.chapter02

/**
 * author: jerry
 * created on: 2020/9/23 7:38 PM
 * description:
 */

fun main() {
    println(ExerciseSample.instance )
    println(ExerciseSample.instance )


    val count = 100
    val intArray = IntArray(count){
        it + 1
    }
    println(intArray.average())

}

class ExerciseSample private constructor(){
    companion object{
        fun newInstance():ExerciseSample{
            return ExerciseSample()
        }

        /**
         * 创建一个 Kotlin 类，这个类需要禁止外部通过构造器创建实例，并提供至少一种实例化方式
         */
        val instance:ExerciseSample by lazy { ExerciseSample() }
    }
}