package com.apache.kotlin.bibibili.chapter02

import androidx.viewpager.widget.ViewPager
import okhttp3.internal.toImmutableMap
import java.math.BigDecimal

/**
 * author: jerry
 * created on: 2020/7/2 12:39 PM
 * description:Kotlin 里那些「不是那么写的」
 */


private data class User(val id:Int,val name: String){
    // 初始化代码块，先于下面的构造器执行
    init {
        println("init 先于构造器执行")
    }
    constructor(id:Int):this(id, "")
    val size:Int
        /**
         * val 和 final 还是有一点区别的，虽然 val 修饰的变量不能二次赋值，但可以通过自定义变量的 getter 函数，让变量每次被访问时，返回动态获取的值
         */
        get() {
            println("size get ")
            return name.length
        }

    companion object{
        val anotherString = "Another String"
    }
}








/**
 * 伴生对象 实现静态变量和静态方法
 * 用 object 修饰的对象中的变量和函数都是静态的，但有时候，我们只想让类中的一部分函数和变量是静态的该怎么做呢：
 */
private class Static{
    companion object{
        val TAG = "TAG"

        init {
            println("companion object init")
        }

        fun method(){
            println("companion object static method")
        }
    }
}

/**
 * object 实现单利
 */
private object StaticClass{
    val number:Int = 1
    fun method(){
        println("object singleinstance method")
    }
}



private open class A{
    open fun method(){
        println("call A method")

    }
}

private interface B{
    fun interfaceMethod()
}

/**
 * Kotlin 中不仅类可以继承别的类，可以实现接口，object 也可以
 * object 其实是把两步合并成了一步，既有 class 关键字的功能，又实现了单例
 */
private  object C: A(),B{
    override fun interfaceMethod() {
        println("call C interfaceMethod")
    }

    override fun method() {
        super.method()
        println("call C method")
    }


}


/**
 * Kotlin 还可以用object: 创建 Java 中的匿名类
 */
val listener = object :ViewPager.SimpleOnPageChangeListener(){
    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
    }
}

/**
 * 除了静态函数这种简便的调用方式，Kotlin 还有更方便的东西：「top-level declaration 顶层声明」。其实就是把属性和函数的声明不写在 class 里面，
 * 这样写的属性和函数，不属于任何 class，而是直接属于 package，它和静态变量、静态函数一样是全局的，但用起来更方便：你在其它地方用的时候，就连类名都不用写
 * 在实际使用中，在 object、companion object 和 top-level 中该选择哪一个呢？简单来说按照下面这两个原则判断：
 *
 *  1.如果想写工具类的功能，直接创建文件，写 top-level「顶层」函数。
    2.如果需要继承别的类或者实现接口，就用 object 或 companion object
 *
 *
 */
fun topLevelFunction(){
    println("topLevelFunction")
}


/**
 * 常量
 * 1.Kotlin 的常量必须声明在对象（包括伴生对象）或者「top-level 顶层」中，因为常量是静态的。
 * 2.Kotlin 新增了修饰常量的 const 关键字。
 * 3.Kotlin 中只有基本类型和 String 类型可以声明成常量。
 *
 */
const val CONST_SECOND_NUMBER = 2
class ConstantValueClass{
    companion object{
        const val CONST_NUMBER = 1
    }
}




fun main() {
    val user = User(18, "Jerry")
    println(user)
    println(user.size)
    User.anotherString


    println(Static.TAG)
    Static.method()

    println(StaticClass.number)
    StaticClass.method()

    topLevelFunction()


    testArrayAndCollection()

}









fun testArrayAndCollection(){
    val strsArray:Array<String> = arrayOf("a","b","c")
    println("${strsArray[0]}, contains:${strsArray.contains("b")}, first:${strsArray.first()}, last:${strsArray.last()}")

    //Kotlin 中的 List 多了一个特性：支持 covariant（协变）。也就是说，可以把子类的 List 赋值给父类的 List 变量：
    val listOf = listOf("a", "b", "c")

    val anys:List<Any> = listOf

    val setOf = setOf("a", "b", "c")

    val mapOf = mapOf("key1" to 1, "key2" to 2, "key3" to 1)



    println("map key2:${mapOf["key2"]}")

    /**
     * 只有 mutableMapOf() 创建的 Map 才可以修改。Kotlin 中集合分为两种类型：只读的和可变的。这里的只读有两层意思：
     * 1.集合的 size 不可变
     * 2.集合中的元素值不可变
     */
    val mutableMapOf = mutableMapOf("key1" to 1, "key2" to 2, "key3" to 1)
    mutableMapOf.put("key4", 4)

    val sequenceOf = sequenceOf("a", "b", "c")

    val asSequence = listOf("a", "b", "c").asSequence()

}


