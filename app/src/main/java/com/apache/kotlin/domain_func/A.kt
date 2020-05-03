package com.apache.kotlin.domain_func

import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-04-18.
 */

//属于 package，不在 class/object 内
fun  topLevelFunction(){
    LogUtils.d("A topLevelFunction")
}
open class A {
    open fun method(){

    }
}