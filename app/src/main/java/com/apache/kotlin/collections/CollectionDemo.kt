package com.apache.kotlin.collections

import com.apache.kotlin.util.LogUtils
import java.util.*

/**
 * Created by Jerry on 2020-04-19.
 */
class CollectionDemo {

    fun  test(){
        var strArray:Array<String> = arrayOf("a","b", "c");
        LogUtils.d("strArray:${Arrays.toString(strArray)}")
        LogUtils.d("contains:${strArray.contains("a")},index[0]: ${strArray.get(0)}, first:${strArray.first()}, last:${strArray.last()}")
        strArray.set(0,"aa")
        LogUtils.d("index[0] get: ${strArray.get(0)}")
        LogUtils.d("index[0] : ${strArray[0]}")

        // val anys: Array<Any> = strArray // compile-error: Type mismatcha Requier Array<Any>, Found Array<String>

        var strList = listOf("a","b","c")
        var list:List<Any> = strList
        var strSet: Set<String> = setOf("a","b","c")
        var anysSet:Set<String> = strSet

        var map = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 3)
        var newMap = map.toMutableMap()
        newMap.put("key5", 5)

        LogUtils.d("map size:${map.size}")
        LogUtils.d("map get key:${map.get("key1")}, map[index]:${map["key2"]}")
        var multableMap = mutableMapOf("key1" to "aa","key2" to "bb","key3" to "cc")
        multableMap.put("key4", "haha")
        LogUtils.d("multableMap size:${multableMap.size}")
    }
}