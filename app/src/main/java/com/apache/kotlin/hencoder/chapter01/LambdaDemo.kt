package com.apache.kotlin.hencoder.chapter01

import android.view.View
import android.widget.TextView

/**
 * Created by Jerry on 2020-05-23.
 */


fun main() {
    val items = listOf(1,2,3)
    println(items)
    val mapItems = items.map { num -> num * 2 }
    println(mapItems)

    a(::b)
    val d = ::b
    b(1)
    d(2) // 地哦啊哦用函数
    (::b)(3)
    val e = d



    a(fun  (param:Int):String{
        return param.toString()
    })

    val f = fun (param:Int):String{
        return param.toString()
    }

//    var e = {
//        return it.toString()
//    }

    var g: (Int) -> String = {
         it.toString()
        "hello"
    }
}

/**
 * 函数a 的参数是一个函数类型，这个函数类型的参数是int，返回值是string
 */
fun a(funParam: (Int) -> String):String{
    return funParam(3)
}

fun b(param:Int) :String{
    return param.toString()
}

/**
 * 函数c 的返回值是一个 函数类型
 */
//fun c(param:Int) : (Int) -> Unit{
//
//}



