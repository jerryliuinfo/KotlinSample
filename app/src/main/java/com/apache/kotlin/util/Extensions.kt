package com.apache.kotlin.util

import android.content.res.Resources
import android.util.TypedValue
import java.lang.reflect.Type

/**
 * author: jerry
 * created on: 2020/7/17 2:42 PM
 * description:
 */

val Float.dp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this,Resources.getSystem().displayMetrics)

val Int.dp
    get() = this.toFloat().dp