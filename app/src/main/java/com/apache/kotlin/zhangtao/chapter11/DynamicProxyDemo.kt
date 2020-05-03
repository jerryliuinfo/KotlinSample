package com.apache.kotlin.zhangtao.chapter11

/**
 * Created by Jerry on 2020-04-27.
 */
interface Animal{
    fun bark()
}

class Dog:Animal{
    override fun bark() {
        println("Wang")
    }

}

class Zoo(animal: Animal):Animal by animal{
    override fun bark() {
        println("bark")
    }
}

fun main(args: Array<String>) {
    Zoo(Dog()).bark()
}