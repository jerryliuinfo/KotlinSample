package com.apache.kotlin.lamada

import android.view.View
import com.apache.kotlin.util.LogUtils
import java.util.*

/**
 * Created by Jerry on 2020-04-23.
 */
class LamadaDemo {
    fun test(){
        val listOf = listOf(1, 2, 3)
        listOf.forEach {
            LogUtils.d("forEach value:$it")
        }

       //LogUtils.d("lamada: ${ a { b(2) }}")
       //a(::b)
        var d = ::b
        d.invoke(1)
        (::b).invoke(1)
        //b.invoke(1) //error

        var e = fun  (param:Int):String{
            return param.toString()
        }

        var f:(Int) ->String = {
            it.toString()
        }
    }

    fun  a(funcParam: (Int) -> String) :String{
        return funcParam(1)
    }

    fun b(param:Int):Int {
        return param
    }

    fun setOnClickListener(onClick:(View) -> Unit){

    }





}