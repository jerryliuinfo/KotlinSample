package com.apache.kotlin

import com.apache.kotlin.zhangtao.chapter03.test
import java.nio.ByteBuffer

/**
 * author: jerry
 * created on: 2020/6/11 5:18 PM
 * description:
 */
fun main() {
//    val buffer = ByteBuffer.allocate(16)
//    println("111 position: ${buffer.position()}, remain:${buffer.remaining()}, limit:${buffer.limit()}")
//    buffer.put(1)
//    println("222 position: ${buffer.position()}, remain:${buffer.remaining()}, limit:${buffer.limit()}")


    // 初始化一个大小为6的ByteBuffer
    // 初始化一个大小为6的ByteBuffer
    val buffer = ByteBuffer.allocate(6)
    println(buffer) // 初始状态：position: 0, limit: 6, capacity: 6


    // 往buffer中写入3个字节的数据

    // 往buffer中写入3个字节的数据
    buffer.put(1.toByte())
    buffer.put(2.toByte())
    buffer.put(3.toByte())
    println(buffer) // 写入之后的状态：position: 3, limit: 6, capacity: 6


    println("************** after flip **************")
    buffer.flip() //切换为读取模式，此时有三个数据可供读取
    println(buffer) // 切换为读取模式之后的状态：position: 0, limit: 3, capacity: 6


    buffer.get()
    buffer.get()
    println(buffer) // 读取两个数据之后的状态：position: 2, limit: 3, capacity: 6


    testCompact()
}


fun testCompact() {
    val buffer = ByteBuffer.allocate(6)
    buffer.put(1.toByte())
    buffer.put(2.toByte())
    buffer.put(3.toByte())
    buffer.put(4.toByte())
    buffer.put(5.toByte())
    buffer.put(6.toByte()) // 初始化一个写满的buffer
    buffer.flip()
    // position: 0, limit: 6, capacity: 6  -- 切换为读取模式
    buffer.get()
    buffer.get()
    // position: 2, limit: 6, capacity: 6  -- 读取两个字节后，还剩余四个字节
    buffer.compact()
    // position: 4, limit: 6, capacity: 6  -- 进行压缩之后将从第五个字节开始
    buffer.put(7.toByte())
    // position: 5, limit: 6, capacity: 6  -- 写入一个字节数据的状态
}