package com.apache.kotlin.usage

/**
 * Created by Jerry on 2020/6/4.
 * 单例
 */
class VodApplicationLifeCallback private constructor() {
    companion object {
        val instance: VodApplicationLifeCallback by lazy { VodApplicationLifeCallback() }
    }

    fun registerApplicationCallback(){
    }



}