package com.apache.kotlin.stringformat

import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-04-22.
 */
class StringFormatDemo {
    fun test(){
        val name = "world"
        val myName = "kotlin"

        val text = """
              Hi $name!
            My name is $myName.\n
        """
        LogUtils.d(text)
    }

    fun testTrimMargin(){
        val name = "world"
        val myName = "kotlin"

        val text = """
              Hi $name!
            My name is $myName.\n
        """.trimMargin()
        LogUtils.d(text)
    }
}