package com.apache.kotlin.bibibili.chapter03

import java.lang.IllegalArgumentException

/**
 * author: jerry
 * created on: 2020/7/11 12:07 AM
 * description: Kotlin 里那些「更方便的」
 */



 class User constructor(name: String){
    var name = name
    var gender:String? = null

    init {
        println("User2 init name:$name")
    }

    constructor(name:String, id:String):this(name)
    constructor(name:String, id:String,age:Int):this(name,id)

}

/**
 * 如果主构造函数中的 constructor 没有任何修饰符，可以去掉
 * 但有些场景，constructor 是不可以省略的，例如在主构造器上使用「可见性修饰符」或者「注解」：
 * 主构造器里声明属性
 */
private class User3(var name:String)

private class User4 private constructor(var name:String)

/**
 * 这种只有一行代码的函数，可以使用 = 连接返回值
 */
fun area(width:Int, height:Int):Int{
    return width * height
}
fun area2(width:Int, height:Int) = width * height

/**
 * 以上是函数有返回值时的情况，对于没有返回值的情况，可以理解为返回值是 Unit：
 */
fun sayHi(name:String) = println("hi $name")


fun sayHi2(name:String = "Jerry") = println("hi $name")

/**
 * 命名参数
 */
fun sayHi3(name: String = "world", age:Int){
    println("sayHi3 name:$name, age:$age")
}

fun sayHi4(name: String, age:Int = 20) =
    println("sayHi4 name:$name, age:$age")


/**
 * 该函数中，检查参数这个部分有些冗余，我们又不想将这段逻辑作为一个单独的
 * 函数对外暴露。这时可以使用嵌套函数，在 login 函数内部声明一个函数：
 */
fun login(user: String, password: String, illegalStr: String){
    if (user.isEmpty()){
        throw IllegalArgumentException(illegalStr)
    }
    if (password.isEmpty()){
        throw IllegalArgumentException(illegalStr)
    }
}

/**
 * 这里我们将共同的验证逻辑放进了嵌套函数 validate 中，并且 login 函数之外
 * 的其他地方无法访问这个嵌套函数
 */
fun login2(user: String, password: String, illegalStr: String){
    fun validate(value:String){
        if (value.isEmpty()){
            throw IllegalArgumentException(illegalStr)
        }
    }
    validate(user)
    validate(password)
}

/**
 * 其实还有另一种更简单的方式：
 * 其中用到了 lambda 表达式以及 Kotlin 内置的 require 函数
 */
fun login3(user: String, password: String, illegalStr: String){
    require(!user.isNullOrBlank()){
        illegalStr
    }
}

fun testArrayCollectionOperator(){
    val originArray = intArrayOf(1,2,3)

    originArray.forEach { it ->
        print(("$it "))
    }
    val filterList = originArray.filter {
        it != 1
    }
    println("filterList:$filterList, originArray:${originArray}")

    val map = originArray.map { it + 1 }
    println("map:$map")

    val flatMap = originArray.flatMap { listOf("${it + 1}", "a") }
    println("flatMap:$flatMap")
}






/**
 * 这里的 trimMargin() 函数有以下几个注意点：
 * | 符号为默认的边界前缀，前面只能有空格，否则不会生效
 * 输出时 | 符号以及它前面的空格都会被删除
 * 边界前缀还可以使用其他字符，比如 trimMargin("/")，只不过上方的代码使用的是参数默认值的调用方式
 *
 *
 */
fun testRawString():String{
    val name = "world"
    val myName = "kotlin"
    val text = """
    |Hi world!
    |My name is kotlin.
"""
    return text
}




/**************** Range开始 *******************/
private fun testRange(){
    var range:IntRange = 0..10 //[0,10]
    range = 0 until 5         //[0,10)
    println("testRange begin ")
    //这里的 in 关键字可以与 for 循环结合使用，表示挨个遍历 range 中的值
    for (i in range){
        print("$i,")
    }
    println()

    //除了使用默认的步长 1，还可以通过 step 设置步长：
    for (i in range step 2){
        print("$i,")
    }
    println()
    //，Kotlin 还提供了递减区间 downTo ，不过递减没有半开区间的用法:
    for (i in 10 downTo 2){
        print("$i,")
    }
    println("testRange end ")

    println()
}

/**************** Range结束 *******************/

/**************** Sequence开始 *******************/
/**
 * 序列 Sequence 又被称为「惰性集合操作」，关于什么是惰性，我们通过下面的例子来理解：
 * 惰性的概念首先就是说在「👇」标注之前的代码运行时不会立即执行，它只是定义了一个执行流程，只有 result 被使用到的时候才会执行

当「👇」的 println 执行时数据处理流程是这样的：

取出元素 1 -> map 为 2 -> filter 判断 2 是否能被 3 整除
取出元素 2 -> map 为 4 -> filter 判断 4 是否能被 3 整除
...
惰性指当出现满足条件的第一个元素的时候，Sequence 就不会执行后面的元素遍历了，即跳过了 4 的遍历。
 */
private fun testSequence(){
    println("testSequence begin ")

    val sequence = sequenceOf(1,2,3,4)
    val result = sequence.map {
        println("map it:$it")
        it * 2
    }.filter {
        println("filter $it")
        it % 3 == 0
    }
    //「👇」
    println(result.sum())


    //而 List 是没有惰性的特性的：
    val resultList = listOf(1, 2, 3, 4)
        .map { i ->
            println("List Map $i")
            i * 2
        }
        .filter { i ->
            println("List Filter $i")
            i % 3  == 0
        }
    //👇
    println(resultList.first()) // 👈 只取集合的第一个元素


}

/**************** Sequence结束 *******************/



/**************** 条件控制  开始 *******************/
private fun testCondition(){
    val a = 4
    val b = 5;
    var max = if (a > b) a else b
    //上面的 if/else 的分支中是一个变量，其实还可以是一个代码块，代码块的最后一行会作为结果返回：
    max = if (a > b) {
        println("max:a")
        a
    }else{
        println("max:b")
        b
    }

    //Kotlin 中用when来判断一个变量与一系列值中某个值是否相等
    when(b){
        3,2 -> { println("3 or 2")}
        4 -> { println("4")}
        else -> { println("else") }
    }

    //在 when 语句中，我们还可以使用表达式作为分支的判断条件： 使用 in 检测是否在一个区间或者集合中：
    when(a){
        in 1..10 -> println("x在取件 1..10中")
        in listOf(1,2) -> println("x在集合中")
        !in 10..20 -> println("x 不在区间 10..20 中")
        else -> println("不在任何区间上")
    }

    //使用 is 进行特定类型的检测：
    val isInt = when(a) {
        is Int -> true
        else -> false
    }
    println("isInt:$isInt")

    //还可以省略 when 后面的参数，每一个分支条件都可以是一个布尔表达式：
    val str1:String = "hello"
    val str2:String = "world"

    when{
        str1.contains("l") -> println("字符串 str1 包含l")
        str2.length == 5 -> println("字符串 str2 的长度为 5")

    }
}

/**************** 条件控制  结束 *******************/


/**************** for循环  开始 *******************/
/**
 * 在 Kotlin 中，表示单个元素的 item ，不用显式的声明类型
 * Kotlin 使用的是 in 关键字，表示 item 是 array 里面的一个元素
 * Kotlin 的 in 后面的变量可以是任何实现 Iterable 接口的对象
 * 在 Java 中，我们还可以这么写 for 循环：
 *for (int i = 0; i <= 10; i++) {
    // 遍历从 0 到 10
   }
 *
 *
 *
 */
private fun testFor(){
    println("测试for循环开始")
    val array = intArrayOf(1,3,5)
    /**
     * Kotlin 中 对数组的遍历是这么写的：
     * 这里与 Java 有几处不同：
    在 Kotlin 中，表示单个元素的 item ，不用显式的声明类型
    Kotlin 使用的是 in 关键字，表示 item 是 array 里面的一个元素
     */
    for (item in array){
        print("$item ")
    }
    println()
    //如果想倒序遍历就该使用标准库中定义的downTo()函数
    for (index in array.size downTo 2){
        print("$index,")
    }
    println()

    for (i in 0..array.size){
        print("$i,")
    }
    println()
    for (i in 0..array.size step 2){
        print("$i,")
    }
    println()
    for ((index,item) in array.withIndex()){
        print("index:$index value:$item, ")
    }
    println("测试for循环结束")

}


/**************** for循环  结束 *******************/



/**************** ?. 和 ?:  开始 *******************/

private fun testMetaExpression(){
    var str:String? = "hello"
    //IDE 报错，Type mismatch. Required:Int. Found:Int?
    //val length:Int = str?.length
    val length = str?.length ?: 2
    println("length:$length")
    validate(User("Hello"))

}

fun validate(user: User) {
    println("begin validate")
    //验证 user.name 是否为空，为空时 return
    val name = user.gender ?: return // 👈 验证 user.name 是否为空，为空时 return
    println("validate name:$name")

}


/**************** ?. 和 ?:  结束 *******************/




/**************** == 和 === 开始 *******************/

/**
 * 在 Java 中，== 比较的如果是基本数据类型则判断值是否相等，如果比较的是 String 则表示引用地址是否相等， String 字符串的内容比较使用的是 equals()
 * Kotlin 中也有两种相等比较方式：
 *  == ：可以对基本数据类型以及 String 等类型进行内容比较，相当于 Java 中的 equals
    === ：对引用的内存地址进行比较，相当于 Java 中的 ==
 */
private fun testEquals(){
    val str1 = "hello"
    val str2 = "hello"
    println("str == str2: ${str1 == str2}, str === str2: ${str1 === str2}")

    val user1 = User("jerry")
    val user2 = User("jerry")
    println("user1 == user2: ${user1 == user2}, user1 === user2: ${user1 === user2}")
}


/**************** == 和 === 结束 *******************/






/**************** try-catch  开始 *******************/

fun testTryCatch(){
    try {
        println("hello")
    } catch (e: Exception) {
    } finally {
    }

    fun  sayHi(){

    }
}

/**************** try-catch  结束 *******************/




fun main() {

    var user3 = User3("jerry")
    println("user3 name:${user3.name}")
    sayHi2() //使用默认值 Jerry
    sayHi2("Alyson")

    sayHi3("abc", 10)
    sayHi3(age = 21)

    sayHi4("haha")
    println(testRawString())
    testArrayCollectionOperator()

    testRange()
    testSequence()
    testCondition()
    testFor()
    testScore()
    testMetaExpression()
    testEquals()

}


private fun testScore(){
    val score = 50 + 73 + 97 + 96 + 54+52+93+100+94+95 + 96+100+87+89+100+95
    println("score:$score")

    val totalScore = 50 + 73 + 97 + 96 + 54+52+93+100+94+95 + 96+100+87+89+100+95 + 255+255
    println("totalScore:$totalScore")

}
