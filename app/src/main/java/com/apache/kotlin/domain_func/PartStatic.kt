package com.apache.kotlin.domain_func

import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-04-18.
 */
class PartStatic {

    val value = 11

    companion object {
        val c:String = "Wesoft"

        init {
            LogUtils.d("companion object init")
        }
    }

}