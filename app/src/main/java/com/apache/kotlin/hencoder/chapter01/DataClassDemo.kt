package com.apache.kotlin.hencoder.chapter01

/**
 * Created by Jerry on 2020-05-23.
 */
private  data class Person(val name:String, val age:Int){
    var grade:Int = 0


//    override fun toString(): String {
//        return "name:$name, age:$age"
//    }
}


fun main() {
    val person1 = Person("jerry",19)
    val person2 = Person("jerry",19)
    person1.grade = 10
    person2.grade = 20
    println(person1 == person2)

    println(person1)


    println("copy:${person1.copy()}")

}