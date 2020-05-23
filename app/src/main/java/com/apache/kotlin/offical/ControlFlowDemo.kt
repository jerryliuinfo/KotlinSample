package com.apache.kotlin.offical

/**
 * Created by Jerry on 2020-05-21.
 */
fun main() {
    testIfExpress(3,5)
}

fun testIfExpress(a:Int, b:Int){
    var max = a
    if (a < b){
        max = b
    }
    println("max:$max")

    var max2:Int
    if (a > b){
        max2 = a
    }else{
        max2 = b
    }
    println("max2:$max2")

    var max3 = if (a > b) a else b
    println("max3:$max3")


}