package com.apache.kotlin.moreconvinient

/**
 * Created by Jerry on 2020-04-22.
 */
class PrimaryConstructorDemo constructor(name:String) {
    var name:String
    init {
        this.name = name
    }

    constructor(name:String, id:Int):this(name)

    constructor(name: String,id: Int,age:Int): this(name,id)



}