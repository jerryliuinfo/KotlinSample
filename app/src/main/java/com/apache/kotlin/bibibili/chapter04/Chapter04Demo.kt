package com.apache.kotlin.bibibili.chapter04

import android.widget.Button
import android.widget.TextView

/**
 * author: jerry
 * created on: 2020/7/26 6:05 PM
 * description:
 */
fun main() {
    //Java
    /*
     *   List<? extends TextView> textViews;
     *  List<? super Button> buttons;
    */

    //Kotlin
    var textviews: List<out TextView>

    //var buttons:List<in TextView>

    /**
     * out 表示我这个变量或者参数只能用来输出，不能用来输入, 只能读我，不能写我
     * in  表示我这个变量或者参数只能用来输入，不能用来输出, 只能写我，不能读我
     */

    /**
     * 另外 Kotlin的 out 和in 不只可以用在变量和参数的声明里，还可以直接用在
     * 泛型类型声明时的类型参数上，它表示我的这个类型只能用来输出或者只用来输入
     */

    /**
     * 多重继承 Java:
     */
    //class Monster<T extends Animal & Food>  {
    //}


    /**
     * Kotlin:
     */
//    private class Monster<T> where T:Animal, T:Food{
//
//    }


    /**
     * 另外 kotlin中有一个java中没有的并且非常实用的关键字 reified, Java泛型里的类型
     * 参数，也就是哪个T,他并不是一个真正的类型，而是一个代号，所以不能把它当做一个普通
     * 对象来用，比如你不能在方法里检查一个对象是不是一个T的实例，这个在java和kotlin中都一样
     */

    //  JAVA 报错
    //    <T> void printIfTypeMatch(Object item){
    //        if (item instanceof T){
    //            System.out.println("item is instance of T");
    //        }
    //    }
    //
    //



}


//报错
//fun <T> printIfTypeMatch(item:Any){
//    if (item is T){
//        println(item)
//    }
//}

//加上 reified可以解除这个 item is T 报错的限制,不过reified自身有个限制，只能用在inline函数上
inline fun <reified T> printIfTypeMatch(item:Any){
    if (item is T){
        println(item)
    }
}




private interface Produce<out T>{
    fun produce():T
}

private interface Consumer<in T>{
    fun consumer(product:T)
}



private class Monster<T> where T:Animal, T:Food{

}

private interface Animal{

}

private interface Food{

}