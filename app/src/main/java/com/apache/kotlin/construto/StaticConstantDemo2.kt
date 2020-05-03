package com.apache.kotlin.construto

/**
 * Created by Jerry on 2020-04-22.
 * 如果既想某些方法和变量是静态的，其他的是非静态的，可以在类
 * 的内部定义companion object
 */
class StaticConstantDemo2 {

    var name:String
        get() {
            TODO()
        }
        set(value) {}

    companion object{
        var SITE = "www.baidu.com"
        fun  printSite() = println(SITE)
    }
}