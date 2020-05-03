package com.apache.kotlin.function_simplify

import android.util.Log
import com.apache.kotlin.util.LogUtils
import java.lang.IllegalArgumentException

/**
 * Created by Jerry on 2020-04-22.
 */
class FunctionSimplifyDemo {

    /**
     * 有返回值的情况
     */
    fun are(width:Int, height:Int):Int{
        return width * height
    }

    fun are2(width:Int, height:Int):Int = width * height

    fun sayHi(name:String){
        LogUtils.d("Hi $name")
    }

    fun sayHi2(name: String) = LogUtils.d("Hi $name")

    fun  sayHello(name: String = "world") = LogUtils.d("Hello $name")
    fun  sayHello2(name: String = "world", age:Int,isStudent: Boolean = true) =
        LogUtils.d("Hello $name, age:$age, isStudent:$isStudent")


    fun login(user:String, pwd:String, illegalStr:String){
        if (user.isEmpty()){
            throw IllegalArgumentException(illegalStr)
        }
        if (pwd.isBlank()){
            throw IllegalArgumentException(illegalStr)
        }

    }

    fun login2(user:String, pwd:String, illegalStr:String){
        fun validate(value:String){
            if (value.isEmpty()){
                throw IllegalArgumentException(illegalStr)
            }
        }
        validate(user)
        validate(pwd)
    }


    fun login3(user:String, pwd:String, illegalStr:String){
       require(user.isNotEmpty()) {illegalStr}
        require(pwd.isNotEmpty()) {illegalStr}
    }

}