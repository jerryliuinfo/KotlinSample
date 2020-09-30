package com.apache.kotlin.bibibili.chapter04

import android.widget.Button
import android.widget.TextView

/**
 * author: jerry
 * created on: 2020/7/26 6:05 PM
 * description: Kotlin 的泛型
 */
fun main() {

    var textViews:List<out TextView>
    var textViews2:List<TextView>

    val producer:Producer<out TextView> = Producer<Button>()
    val produce:TextView? = producer.produce()




//    val context:Context? = null
//
//    val consumer:Consumer<in Button> = Consumer<TextView>()
//    consumer.consumer(Button(context))
//
//
//
//    val producer2:Producer2<TextView> = Producer2<Button>()
//    val produce2:TextView? = producer2.produce()
//
//    val consumer2:Consumer2<Button> = Consumer2<TextView>()
//    consumer2.consumer(Button(context))


    val listOf = listOf("a", "b", "c")
    val joinToString = listOf.joinToString(separator = "_") //a_b_c
    println(joinToString)



}

/**
 * Java 里的泛型参数 T 并不是一个真正的类型, 而是一个代号, 所以
 * 不能当做一个普通的类型来用，比如你不能在方法里检查一个对象是不是一个T的实例
 * 下面的代码会报错, 在Kotlin中也一样，但是Kotlin中用 「 reifined 」关键字可以
 * 解决这个问题, 但是reifined 有个限制：必须用在inline 函数上
 */
inline fun <reified T> printIfTypeMathc(item:Any){
    if (item is T){
        println(item)
    }
}



class Producer<T>{
    fun produce():T?{
        return null
    }
}

/**
 * 前面的例子中，在声明 Producer 的时候已经确定了泛型 T 只会作为输出来用，
 * 但是每次都需要在使用的时候加上 out TextView 来支持协变，写起来很麻烦。
 *  Kotlin 提供了另外一种写法：可以在声明类的时候，给泛型符号加上 out 关键字，表明泛型参数 T 只会用来输出，在使用的时候就不用额外加 out 了
 */
class Producer2< out T>{
    fun produce():T?{
        return null
    }
}

class Consumer<T>{
    fun consumer(t:T){

    }
}

class Consumer2<in T>{
    fun consumer(t:T){

    }
}


class Monster<T> where T : Animal, T : Food?

interface Animal

interface Food

