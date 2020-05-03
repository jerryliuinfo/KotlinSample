package com.apache.kotlin.zhangtao.chapter09

/**
 * Created by Jerry on 2020-04-27.
 */
class StaticMethodDemo {


    companion object{
        fun isEmpty(str:String):Boolean{
            return str == ""
        }
    }
}