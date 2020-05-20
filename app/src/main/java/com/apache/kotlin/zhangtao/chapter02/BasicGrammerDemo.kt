package com.apache.kotlin.zhangtao.chapter02

import com.apache.kotlin.util.LogUtils
import kotlin.reflect.KClass

/**
 * Created by Jerry on 2020-04-25.
 */
var name2:String? = null
var name :String = "Jerry"
fun main(args: Array<String>) {
//    name = name2!!
    testPassJavaClassParam(JavaMain::class.java)
   //testPassKotlinClassParam(KotlinMain::class)
    println(JavaMain.`in`)

}

fun  echo(name:String){
    println("$name")
}


fun testPassJavaClassParam(clazz:Class<JavaMain>){
    println("testPassJavaClassParam:${clazz.simpleName}")
}

fun testPassKotlinClassParam(clazz:KClass<KotlinMain>){
    println("testPassKotlinClassParam:${clazz.simpleName}")
}