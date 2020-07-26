package com.apache.kotlin.bibibili.chapter02

import android.os.SystemClock
import androidx.viewpager.widget.ViewPager
import com.apache.kotlin.zhangtao.chapter03.test
import okhttp3.internal.toImmutableMap
import java.math.BigDecimal

/**
 * author: jerry
 * created on: 2020/7/2 12:39 PM
 * description:Kotlin 里那些「不是那么写的」
 */





private class User{
    val id:Int
    val name:String
    // 初始化代码块，先于下面的构造器执行
    init {
        println("init")
    }

    constructor(id:Int, name: String){
        println("constructor ")
        this.id = id
        this.name = name
    }
}

/**
 * data class
 */
private data class User2(val id:Int, val name:String){
    constructor(id:Int):this(id, "")
}

//常量
val final = 1

/**
 * Kotlin 函数参数默认是 val 类型，所以参数前不需要写 val 关键字
 */
fun method(final2:String){

}



private  class User3(val id:Int, val name:String){
    constructor(id:Int):this(id, "")

    val size:Int
    /**
     * val 和 final 还是有一点区别的，虽然 val 修饰的变量不能二次赋值，但可以通过自定义变量的 getter 函数，让变量每次被访问时，返回动态获取的值
     */
    get() {
        println("size get")
        return name.length
    }

}

/**
 * 伴生对象 实现静态变量和静态方法
 */
class Static{
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
object SInstance{
    val number:Int = 1
    fun method(){
        println("object singleinstance method")
    }
}



 open class A{
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
 object C: A(),B{
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

private class Sample{
    val number = 1
    fun method(){
        println("Sample method")
    }
}


fun main() {
    val user = User(18, "Jerry")
    println(user)

    val user2 = User2(20,"Tom")
    println(user2)

    println(final)

    val user3 = User3(20,"Hello")
    println(user3.size)


    println(Static.TAG)
    Static.method()

    println(SInstance.number)
    SInstance.method()

    topLevelFunction()


    //数组和集合
    val strs:Array<String> = arrayOf("a", "b","c")
    println("get:${strs[1]}, contains:${strs.contains("b")}, first:${strs.first()}, last:${strs.last()}")

    //Kotlin 的数组编译成字节码时使用的仍然是 Java 的数组，但在语言层面是泛型实现，这样会失去协变 (covariance) 特性，就是子类数组对象不能赋值给父类的数组变量：
    //val anys:Array<Any> = strs; //compile-error: Type mismatch

    val strList:List<String> = listOf("a","b","c")
    val anys:List<Any> = strList
    println("listAnys:$anys")


    val strSet = setOf("a","b", "c")

    var map = mapOf("key1" to 1, "key2" to 2, "key3" to 3)
    println("value1: ${map.get("key1")}, value2:${map["key2"]}")
    val immutableMap = map.toImmutableMap()


    val sample = Sample()
    sample.method()


    //exercise
    println(ExerciseSample.newInstance())
    println(ExerciseSample.newInstance())

    println(ExerciseSample.instance)
    println(ExerciseSample.instance)

    testCost()

}


private class ExerciseSample private constructor(){
    companion object{
        fun newInstance():ExerciseSample{
            return ExerciseSample()
        }

        val instance:ExerciseSample by lazy { ExerciseSample() }
    }
}



fun testCost(){
    var starTime = System.nanoTime()
    var array = Array(1_000_000) { it -> it.inc() }
    var sumArray = 0
//    array.forEach {
//        sumArray += it
//    }
    for (it in array){
        sumArray += it
    }
    var arrayAverage = BigDecimal(sumArray).divide(BigDecimal(array.size)).setScale(2, BigDecimal.ROUND_HALF_UP)

    println("Array average value:$arrayAverage, cost time:${System.nanoTime() -starTime}")

    starTime = System.nanoTime()
    sumArray = array.sum()
    println("Array sum average value:${BigDecimal(sumArray).divide(BigDecimal(array.size)).setScale(2, BigDecimal.ROUND_HALF_UP)}, " +
            "cost time:${System.nanoTime() -starTime}")


    sumArray = 0
    starTime = System.nanoTime()
    val intArray = IntArray(1_000_000) { it -> it.inc() }

    for (it in intArray){
        sumArray += it
    }
    println("IntArray average value:$arrayAverage, cost time:${System.nanoTime() -starTime}")
    starTime = System.nanoTime()
    sumArray = intArray.sum()
    println("IntArray sum average value:${BigDecimal(sumArray).divide(BigDecimal(array.size)).setScale(2, BigDecimal.ROUND_HALF_UP)}, " +
            "cost time:${System.nanoTime() -starTime}")



    sumArray = 0
    starTime = System.nanoTime()
    val list = List(1_000_000) { it -> it.inc() }

    for (it in list){
        sumArray += it
    }
    println("List average value:$arrayAverage, cost time:${System.nanoTime() -starTime}")
    starTime = System.nanoTime()
    sumArray = list.sum()
    println("List sum average value:${BigDecimal(sumArray).divide(BigDecimal(array.size)).setScale(2, BigDecimal.ROUND_HALF_UP)}, " +
            "cost time:${System.nanoTime() -starTime}")

}


fun testIntArray(){
    val starTime = System.nanoTime()
    val array = IntArray(1_000_000) { it -> it.inc() }
    var sumArray = 0
    array.forEach {
        sumArray += it
    }
    var arrayAverage = BigDecimal(sumArray).divide(BigDecimal(array.size)).setScale(2, BigDecimal.ROUND_HALF_UP)

    println("average value:$arrayAverage, cost time:${System.nanoTime() -starTime}")
}