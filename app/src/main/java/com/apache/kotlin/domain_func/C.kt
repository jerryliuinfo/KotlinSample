package com.apache.kotlin.domain_func

import com.apache.kotlin.util.LogUtils

/**
 * Created by Jerry on 2020-04-18.
 */
class C :A(),B {
    override fun interfaceMethod() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        LogUtils.d("C interfaceMethod")

    }

    override fun method() {
        super.method()
        LogUtils.d("C method")
    }

}