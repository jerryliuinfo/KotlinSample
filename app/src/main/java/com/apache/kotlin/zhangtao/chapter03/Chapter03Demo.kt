package com.apache.kotlin.zhangtao.chapter03

import com.apache.kotlin.zhangtao.chapter02.JavaMain
import java.io.File

/**
 * Created by Jerry on 2020-04-26.
 */
fun main(args: Array<String>) {
    AJavaImpl.a.putNumber(123)
    AJavaImpl.a.putNumber(345)


    test("")

    val age:Int = 18
    val name:String = "Jerr"
    nestedFunction()

    val file = File("/sdcard/test.txt")
    file.readText( Charsets.UTF_8)
}


fun test(str: String){
    val fmt1 = JavaMain.format(str)
    //val fmt2:String = JavaMain.format(str)
    val fmt3:String? = JavaMain.format(str)
    println(fmt3?.length)
}


fun nestedFunction(){
    val str = "Hello world"
    fun say(count:Int = 5){
        println("$str $count")
        if (count > 0){
            say(count - 1)
        }
    }
    say()
}