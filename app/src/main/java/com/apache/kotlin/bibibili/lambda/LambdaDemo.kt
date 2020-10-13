package com.apache.kotlin.bibibili.lambda

/**
 * author: jerry
 * created on: 2020/10/13 12:30 PM
 * description:
 */


fun main() {
   sum(10) {
       println("result:$it")
   }
}


fun sum(x:Int, action: (Int) -> Unit){
    action.invoke(x + 1)
}