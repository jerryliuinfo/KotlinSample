package com.apache.kotlin.zhangtao.chapter05

/**
 * Created by Jerry on 2020-04-26.
 */

open class Animal

class Dog:Animal()



fun main(args: Array<String>) {
   Dog().printName(Dog())
}

fun Animal.name() = "animal"
fun Dog.name() = "dog"

fun Animal.printName(anim:Animal){
    println(anim.name())
}