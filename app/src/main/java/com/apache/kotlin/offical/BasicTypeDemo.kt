package com.apache.kotlin.offical

/**
 * Created by Jerry on 2020-05-21.
 */

val oneLong = 340L
val oneByte:Byte = 1
val oneDouble = 3.14159267891
val oneFloat = 3.123123345580f

fun main() {
    println("oneDouble:${oneDouble}, oneFloat:${oneFloat}")

    fun printDouble(value:Double){
        println("printDouble:$value")
    }

    val i = 1
    val d = 1.1
    val f = 1.1f

    printDouble(d)

    testUndercore()
    testPresentation()
    testExplicitConversions()
    testOperations()
    println("testChar('A'): ${testChar('1')}")
    testArray()
    testPrimitiveTypeArrays()
    testStringLiterals()

}

fun testStringLiterals(){
    val s = "Hello, world!\n"
    print(s)

    val text = """
        for (c in "foo")
            print(c)
    """
    println("testStringLiterals text:$text")


    var text2 = """
    |Tell me and I forget.
    |Involve me and I learn.
    """
    println(text2)
    println("trimMargin defaulut:${text2.trimMargin()}"  )
    println("trimMargin >:${text2.trimMargin(">")}"  )


    //原始字符串和转义字符串中均支持模板。如果需要$在原始字符串中表示文字字符（不支持反斜杠转义），则可以使用以下语法：
    val price = """
        ${'$'}9.99
    """
    println("$price")



}

fun testPrimitiveTypeArrays(){
    val x:IntArray = intArrayOf(1,2,3)
    x[0] = x[1] + x[2]
    println("IntArray x[0]:${x[0]}")

    var array1:IntArray = IntArray(5)
    //[0,0,0,0,0]
    println("IntArray array1:$array1")

    var array2:IntArray= IntArray(5){2}
    println("IntArray array2:$array2")

    var array3 = IntArray(5) {
        println(it)
        it
    }

}

fun testArray(){
    val array = arrayOf(1,2,3)
    println("testArray:${array}")

    val asc = Array(3){ (it * it) }
    asc.forEach {
        println("testArray item:$it")
    }

    var stringArray:Array<String> = arrayOf("1","2","3")
    var anyArray: Array<out Any> = arrayOf("1","2","3")
    anyArray = stringArray



}


fun  testChar(c:Char):Int{
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // Explicit conversions to numbers
}

//shl(bits) –左移标志
//shr(bits) –右移签名
//ushr(bits) –无符号右移
//and(bits)–按位和
//or(bits)–按位或
//xor(bits)–按位异或
//inv() –按位反转
fun testBitwiseOperations(){
    val a = 1 // 0000 0001
    val b = 2 // 0000 0010
    val shl = a shl b
    val shr = a shr b
    val ushr = a ushr b
    val and = a and b
    val or = a or b
    val xor = a xor b
    println("shl:$shl, shr:$shr,ushr:$ushr, ushr:$ushr, and:$and, or:$or, xor:$xor")
}



fun testUndercore(){
    //您可以使用下划线使数字常数更具可读性
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    println("oneMillion:$oneMillion, creditCardNumber:$creditCardNumber")
}

fun testPresentation(){
    val a: Int = 10000
    println("testPresentation ${a === a}") // Prints 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println("testPresentation ${boxedA === anotherBoxedA}") // Prints 'true'

}

fun testExplicitConversions(){
    val a:Int ? = 1
    //val b:Long ? = a //编译报错
    val c:Long? = a?.toLong()
    println("testExplicitConversions c:$c")

}


/**
 * 操作符
 */
fun testOperations(){
    //整数之间的除法总是返回整数。丢弃任何小数部分。例如 5 /2 = 2
    val x = 5 /2
    val y = 5L /2

    //若要返回浮点类型，请将参数之一显式转换为浮点类型。
    val z = 5 /2.toDouble()
    println("testOperations x:$x, y:$y, z:$z")
}