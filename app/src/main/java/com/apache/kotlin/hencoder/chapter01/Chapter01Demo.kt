package com.apache.kotlin.hencoder.chapter01

import android.view.View
import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-05-20.
 */
fun main() {
    val user = User()
    println("length:${user.name?.length}")
    user.name = "jerry"

    println("Hello "+ user.name )

}

class User{
    var name:String? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }

    val id:String ? = "1"
}