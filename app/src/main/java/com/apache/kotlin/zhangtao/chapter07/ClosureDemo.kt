package com.apache.kotlin.zhangtao.chapter07

/**
 * Created by Jerry on 2020-04-26.
 */
val echo = {name:String ->
    println(name)
}


val lambdaA ={
    a:Int,b:Int, c:Int, d:Int -> print("Jerry")
}

fun main(args: Array<String>) {
    echo.invoke("Jerry")
    echo("Qibao")

    lambdaA(1,2,3,4)
}