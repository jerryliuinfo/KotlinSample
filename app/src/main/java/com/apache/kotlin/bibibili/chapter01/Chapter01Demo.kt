package com.apache.kotlin.bibibili.chapter01

import android.view.View
import com.apache.kotlin.util.LogUtils

/**
 * author: jerry
 * created on: 2020/7/1 1:06 PM
 * description:Kotlin 的变量、函数和类型
 */

/**
 * 变量声明
 */

//可读可写变量
var age: Int = 10

//只读变量
val size = 20

//延迟初始化
lateinit var textview: View

fun topLevelFunction(){
    println("topLevelFunction")
}



//Kotlin中抛弃了java中的 int float等基本类型，也没有了Integer Float 而是统一用Int Float


//类型推断,不用写变量类型
val count = 1 //Int
val pi = 3.14f //Float


/**
 * 函数声明
 */
private fun  cook(name:String):String{
   return "meat"
}

private fun foo(name:String){

}

private class User{
    var name = "Mike"
        get() {
            println("User get name value:$field")
            return field
        }
        set(value) {
            println("User set name value:$value")
            field = value
        }
    fun run(){
        name = "Mary"
        println(name)

    }
}


//get set专属写法
private var name: String? = "Jerry"
    get() {
        println("name get: $field")
        return field
    }

    set(value2) {
        println("name set: $value2")

        field = value2
    }


//abstract 关键字，
private abstract class Foo {
    abstract fun test()
}




//类型的判断和强转
private open class AActivity{

}
private class NewActivity: AActivity() {
    fun action(){
        println("user action")
    }
}

fun main() {

    val user = User()
    user.name = "Jerry"
    println(user.name)

    println(name?.length)
    name = "Hello"
    println(name)

    val activity:AActivity = NewActivity()
    //报错
    //activity.action

    /**
     * user.action
     * 使用 is 强转
     */
    if (activity is NewActivity){
        activity.action()
    }
    //使用as 关键字
    (activity as NewActivity).action()
    //或者
    activity.action()



}


