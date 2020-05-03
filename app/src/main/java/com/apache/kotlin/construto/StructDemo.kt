package com.apache.kotlin.construto

import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-04-22.
 */
class StructDemo {
    val name:String


    constructor(name: String) {
        this.name = name
    }

    init {
        LogUtils.d("init")
    }
}