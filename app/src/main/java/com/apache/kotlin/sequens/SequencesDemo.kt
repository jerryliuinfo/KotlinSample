package com.apache.kotlin.sequens

import com.apache.kotlin.domain_func.User
import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-04-19.
 */
class SequencesDemo {




    fun  test(){
        //类似 listOf() ，使用一组元素创建：
        var sequenceOf = sequenceOf("a", "b", "c")

        var list = listOf("Jerry", "Alyson", "shiqi")
        sequenceOf = list.asSequence()



        val iterator = sequenceOf.iterator()
        while (iterator.hasNext()){
            LogUtils.d(iterator.next())
        }



    }
}