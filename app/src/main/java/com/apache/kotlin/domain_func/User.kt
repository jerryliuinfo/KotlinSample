package com.apache.kotlin.domain_func

/**
 * Created by Jerry on 2020-04-17.
 */
class User {


    var name: String
    get() {
        return field + " nb"
    }
    set(value) {
        field = "Cute" + value
    }

    init {
        print("User init")
    }

    constructor(name: String) {
        this.name = name
        print("User constructor")
    }

    fun  test(name:String){

    }

    companion object{
        val constantValue = "Another thing"
    }

}

