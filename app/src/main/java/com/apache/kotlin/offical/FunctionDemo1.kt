package com.apache.kotlin.offical

import com.apache.kotlin.zhangtao.chapter07.lambdaA
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Jerry on 2020-05-30.
 */
open class ClassA {
    open fun foo(i: Int = 10) {
        println("ClassA foo i:$i")
    }
}

class ClassB:ClassA() {
    override fun foo(i: Int) {
        super.foo(i)
        println("ClassB foo i:$i")

    }


    fun baz(i: Int = 1,baz:Int){
        println("ClassB baz i:$i, baz:$baz")

    }

    fun lambda(bar: Int = 2, baz: Int = 1, qux: ( value:Int) ->Unit){
        println("lambda bar:$bar, baz:$baz, qux:$qux")
    }
}


fun reformat(str: String,
             normalizeCase: Boolean = true,
             wordSeparator: Char = ' ') {
    println("str:$str, normalizeCase:$normalizeCase,wordSeparator:$wordSeparator")

}


fun  varagsFunction(vararg strings:String){
    println(strings.contentToString())
}

fun unitReturnTypeFunction(name:String?):Unit{
    if (name != null){
        println("hello $name")
    }else{
        println("Hi there")
    }
    // `return Unit` 或者 `return` 是可选的
}

/**
 * 当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可：
 */
fun double(x:Int):Int = x * 2

/**
 * 具有块代码体的函数必须始终显式指定返回类型，除非他们旨在返回 Unit，在这种情况下它是可选的。 Kotlin
 * 不推断具有块代码体的函数的返回类型，因为这样的函数在代码体中可能有复杂的控制流，
 * 并且返回类型对于读者（有时甚至对于编译器）是不明显的。
 */
fun double2(x:Int):Int {
   return x * 2
}

/**
 * 函数的参数（通常是最后一个）可以用 vararg 修饰符标记：
 * 在函数内部，类型 T 的 vararg 参数的可见方式是作为 T 数组，
 * 即上例中的 ts 变量具有类型 Array <out T>。
 *只有一个参数可以标注为 vararg。如果 vararg 参数不是列表中的最后一个参数，
 * 可以使用具名参数语法传递其后的参数的值，或者，如果参数具有函数类型，则通过在括号外部传一个 lambda
 *
 *
 */
fun <T> asList(vararg ts:T):List<T>{
    val result = ArrayList<T>()
    for (t in ts){
        result.add(t)
    }
    return result
}

/**
 * 标有 infix 关键字的函数也可以使用中缀表示法（忽略该调用的点与圆括号）调用。中缀函数必须满足以下要求：
 *
 * 它们必须是成员函数或扩展函数；
    它们必须只有一个参数；
    其参数不得接受可变数量的参数且不能有默认值。
 */
infix fun Int.increment(x: Int): Int {
    return x + 1
}


fun main() {
    val clzB = ClassB()
    /**
     * 覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时，必须从签名中省略默认参数值：
     */
    clzB.foo(5)
    /**
     * 如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该函数来使用：
     */
    clzB.baz(2,3)


    /**
     * 如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为具名参数在括号内传入，也可以在括号外传入：
     */
    clzB.lambda(1){ println("使用1个默认值")}
    clzB.lambda {  println("使用2个默认值")}
    clzB.lambda(qux = { println("lambda写在花括号内")})


    val str = "Hello"
    //使用默认参数来调用
    reformat(str)

    reformat(str,
        normalizeCase = true,
        wordSeparator = '_'
    )

    /**
     * 可以通过使用星号操作符将可变数量参数（vararg） 以具名形式传入：
     */
    varagsFunction(* arrayOf("a","b","c"))

    unitReturnTypeFunction(null)
    unitReturnTypeFunction("Jerr")

    println(double(3))
    println(double2(3))


    println(asList("a",100,"b").toString())


    val a = arrayOf(1,2,3)
    val list = asList(-1,0,*a,4)
    println(list)


    println(1.increment(2))
    // 等同于这样
    println(1 increment(2))


}