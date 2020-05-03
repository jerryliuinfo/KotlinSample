package com.apache.kotlin.moreconvinient

/**
 * Created by Jerry on 2020-04-22.
 * 加上var，可以不用定义变量，会自动复制
 */
class PrimaryConstructorDemo3 (var name:String) {
}
//等价于
//class PrimaryConstructorDemo3 ( name:String) {
//    var name:String = name
//}