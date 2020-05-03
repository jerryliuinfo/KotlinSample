package com.apache.kotlin.construto

/**
 * Created by Jerry on 2020-04-22.
 */
class StaticConstantDemo {

    /**
     * Java 里面写常量，我们用的是 static + final。而在 Kotlin 里面，除了 final 的写法不一样，static 的写法也不一样，而且是更不一样。确切地说：在 Kotlin 里，静态变量和静态方法这两个概念被去除了。
     * 如果想在 Kotlin 中像 Java 一样通过类直接引用该怎么办呢？Kotlin 的答案是 companion object：
     */
    companion object{
        var SITE = "www.baidu.com"
    }
}