package com.apache.kotlin.offical

/**
 * Created by Jerry on 2020-05-25.
 * 有时要修改某类,但不改变原类并且不显式声明子类.
 * 对于这种情况,Java使用匿名内部类,
 * 而Kotlin使用:
 * 对象表达式(object expressions),
 * 对象声明(object declarations),
 * 伴生对象(companion object)
 *
 * 对象表达式和对象声明之间的语义差异:
 *
 * 1. 对象表达式是在使用他们的地方立即执行（及初始化）的
 * 2. 对象声明是在第一次被访问到时延迟初始化的；
 * 3. 伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配。
 *
 *
 *
 */
open class A(x: Int) {
    open val y: Int = x
}

interface B { /*...*/ }

/**
 * 如果超类型有一个构造函数，则必须传递适当的构造函数参数给它。 多个超类型可以由跟在冒号后面的逗号分隔的列表指定：
 */
val ab: A = object : A(1), B {
    //override val y = 15
}

fun foo() {
    val adHoc = object {
        var x: Int = 1
        var y: Int = 2
    }
    print(adHoc.x + adHoc.y)
}


class C {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
        //val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}



fun main() {
    println(ab.y)

    foo()
}